package com.lol.higg_v2.controller;

import com.lol.higg_v2.entity.HiggComment;
import com.lol.higg_v2.service.CommentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/{puuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HiggComment> getList(@PathVariable("puuid") String puuid, Model model) {

        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+puuid);
        model.addAttribute("comment", commentService.getList(puuid));
        log.info("comment@@@@@@@@@@@@@@@@@@@" + commentService.getList(puuid));
        return commentService.getList(puuid);
    }

    @PostMapping("/post")
    public void postin(@RequestBody HiggComment higgComment) {
        commentService.insertComment(higgComment);
    }

    @DeleteMapping("/delete/{idx}")
    public long deleteComment(@PathVariable("idx") Integer idx){
        return commentService.deleteComment(idx);
    }

    @PutMapping("/put/{idx}")
    public void updateComment(@PathVariable("idx") Integer idx, @RequestBody HiggComment higgComment){
        higgComment.setIdx(idx);
        log.info(higgComment + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        commentService.update(higgComment);
    }

}

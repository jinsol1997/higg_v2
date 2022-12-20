package com.lol.higg_v2.controller;

import com.lol.higg_v2.entity.HiggComment;
import com.lol.higg_v2.service.CommentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/comment/ajaxselect")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/{puuid}")
    public List<HiggComment> getList(@PathVariable("puuid") String puuid, Model model) {

        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+puuid);
        model.addAttribute("comment", commentService.getList(puuid));
        log.info("comment@@@@@@@@@@@@@@@@@@@" + commentService.getList(puuid));
        return commentService.getList(puuid);
    }

    @PostMapping
    public void postin(@RequestBody HiggComment higgComment) {
       log.info(higgComment + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        commentService.insertComment(higgComment);
    }

}

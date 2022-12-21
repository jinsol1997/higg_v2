package com.lol.higg_v2.service;

import com.lol.higg_v2.dto.member.HiggCommentDTO;
import com.lol.higg_v2.entity.HiggComment;
import com.lol.higg_v2.repository.HiggCommentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@Service
public class CommentService {
    //댓글 Service
    @Autowired
    HiggCommentRepository higgCommentRepository;

    public List<HiggComment> getList(String puuid) {
        log.info("List Service 진입@@@");
        log.info(higgCommentRepository.findByPuuid(puuid));
        return higgCommentRepository.findByPuuid(puuid);
    }

    public HiggComment insertComment(HiggComment higgComment) {
        log.info("서비스 ");
        log.info(higgComment.getWriter());
        log.info(higgComment.getReply());
        log.info(higgComment.getPuuid());
        higgComment.setReplydate(LocalDate.now());
        log.info(higgComment.getReplydate());
        return higgCommentRepository.save(higgComment);
    }

    public long deleteComment(Integer idx) {
        return higgCommentRepository.deleteByIdx(idx);
    }

    public HiggComment update(HiggComment higgComment){
        higgComment.setUpdatedate(LocalDate.now());
        return higgCommentRepository.save(higgComment);
    }
}

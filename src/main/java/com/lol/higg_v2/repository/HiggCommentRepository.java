package com.lol.higg_v2.repository;

import com.lol.higg_v2.entity.HiggComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HiggCommentRepository extends JpaRepository<HiggComment, Integer> {
    List<HiggComment> findByPuuid(String puuid);


}

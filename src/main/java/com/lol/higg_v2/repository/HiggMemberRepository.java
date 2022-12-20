package com.lol.higg_v2.repository;

import com.lol.higg_v2.entity.HiggMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HiggMemberRepository extends JpaRepository<HiggMember, Integer> {
    Optional<HiggMember> findByUid(String uid);


}

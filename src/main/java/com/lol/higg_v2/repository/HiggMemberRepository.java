package com.lol.higg_v2.repository;

import com.lol.higg_v2.entity.HiggMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiggMemberRepository extends JpaRepository<HiggMember, Integer> {
}

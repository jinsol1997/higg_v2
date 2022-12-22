package com.lol.higg_v2.service;

import com.lol.higg_v2.entity.HiggMember;
import com.lol.higg_v2.repository.HiggMemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MemberService {


    @Autowired
    HiggMemberRepository higgMemberRepository;

    public HiggMember insertMember(HiggMember higgMember) {
        //회원가입
        log.info("회원가입 서비스");
        return higgMemberRepository.save(higgMember);
    }

    public HiggMember selectByUid(String uid) {
        return higgMemberRepository.findByUid(uid).get();
    }


}

package com.lol.higg_v2;

import com.lol.higg_v2.entity.HiggMember;
import com.lol.higg_v2.repository.HiggMemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootTest
@Log4j2
public class MemberRepositoryTest {

    @Autowired
    private HiggMemberRepository higgMemberRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void memberSaveTest(){

        HiggMember higgMember = HiggMember.builder().uid("sad").pw(encoder.encode("1111")).role("USER").build();

        log.info(higgMember);

        log.info(higgMemberRepository.save(higgMember));
    }
}

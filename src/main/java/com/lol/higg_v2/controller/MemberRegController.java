package com.lol.higg_v2.controller;

import com.lol.higg_v2.dto.member.HiggMemberDTO;
import com.lol.higg_v2.entity.HiggMember;
import com.lol.higg_v2.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("member/register")
public class MemberRegController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public void getForm() {}

    @PostMapping
    public String reg(HiggMemberDTO memberDTO) {
        log.info("회원가입 컨트롤러...");

        memberDTO.setPw(passwordEncoder.encode(memberDTO.getPw()));

        HiggMember higgMember = memberDTO.toHiggMemberEntity();

        memberService.insertMember(higgMember);

        return "/higg/main";

    }
}

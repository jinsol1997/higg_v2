package com.lol.higg_v2.controller;

import com.lol.higg_v2.dto.member.HiggMemberDTO;
import com.lol.higg_v2.entity.HiggMember;
import com.lol.higg_v2.service.MemberService;
import com.lol.higg_v2.util.Encrypt;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public String getForm() {
        return "member/regForm";
    }

    @PostMapping
    public String reg(HiggMember memberDTO) {
        log.info("회원가입 컨트롤러...");

        String salt = Encrypt.getSalt();
        memberDTO.setPw(Encrypt.getEncrypt(memberDTO.getPw(), salt));


        memberService.insetMember(memberDTO);

        return "/higg/main";

    }
}

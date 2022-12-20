package com.lol.higg_v2.controller;

import com.lol.higg_v2.entity.HiggMember;
import com.lol.higg_v2.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("main/Login")
public class LoginController {
    //로그인 Controller
    @Autowired
    private MemberService memberService;


    @PostMapping
    public String login(HiggMember loginTry, HttpSession session) {

        HiggMember member = memberService.selectByUid(loginTry.getUid());


        if(member != null){
            session.setAttribute("loginInfo", member.toLoginInfo());
        }

        return "/higg/main";
    }


}

package com.lol.higg_v2.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Log4j2
@Controller
public class LogOutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        log.info("로그아웃 되었습니다->" + session);
        return "redirect:/higg/main";
    }
}

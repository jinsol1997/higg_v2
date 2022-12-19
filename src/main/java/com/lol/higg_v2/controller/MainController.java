package com.lol.higg_v2.controller;

import com.google.gson.Gson;
import com.lol.higg_v2.dto.lol.SummonerDTO;
import com.lol.higg_v2.util.ApiKey;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("/higg/main")
public class MainController {

    @GetMapping
    public void mainForm() {
    }

    @PostMapping
    public String search(@RequestParam("searchName") String searchName, HttpSession session) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();

        String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + searchName + "?" + ApiKey.key;

        String result = restTemplate.getForObject(url, String.class, httpHeaders);

        Gson gson = new Gson();
        SummonerDTO summonerDTO = gson.fromJson(result, SummonerDTO.class);

        session.setAttribute("summonerDTO", summonerDTO);

        return "redirect:/higg/list";
    }

}

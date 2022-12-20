package com.lol.higg_v2.controller;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import com.lol.higg_v2.dto.lol.LeagueEntryDTO;
import com.lol.higg_v2.dto.lol.MatchDTO;
import com.lol.higg_v2.dto.lol.SummonerDTO;
import com.lol.higg_v2.service.CommentService;
import com.lol.higg_v2.util.ApiKey;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;


@Log4j2
@Controller
@RequestMapping("/higg/list")
public class ListController {

    @Autowired
    CommentService commentService;

    @GetMapping()
    public void listForm(Model model, HttpSession session) {

        SummonerDTO summonerDTO = (SummonerDTO) session.getAttribute("summonerDTO");

        String url = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + summonerDTO.getPuuid() + "/ids?start=0&count=10&" + ApiKey.key;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        Gson gson = new Gson();

        String result = restTemplate.getForObject(url, String.class, httpHeaders);
        String[] gameCode = gson.fromJson(result, String[].class);

        MatchDTO[] matchDTO = new MatchDTO[gameCode.length];

        for (int i = 0; i < gameCode.length; i++) {
            url = "https://asia.api.riotgames.com/lol/match/v5/matches/" + gameCode[i] + "?" + ApiKey.key;
            matchDTO[i] = restTemplate.getForObject(url, MatchDTO.class);
        }

        url = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerDTO.getId() + "?" + ApiKey.key;

        result = restTemplate.getForObject(url, String.class, httpHeaders);

        List<LeagueEntryDTO> list = gson.fromJson(result, new TypeToken<List<LeagueEntryDTO>>() {
        }.getType());

        for (int i = 0; i < list.size(); i++) {

            if(list.get(i) != null){
                char[] chars = list.get(i).getTier().toLowerCase().toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                list.get(i).setTier(String.valueOf(chars));
            }

            if(list.get(i).getQueueType().equals("RANKED_SOLO_5x5")){
                model.addAttribute("soloRankEntryDTO", list.get(i));
            } else if(list.get(i).getQueueType().equals("RANKED_FLEX_SR")){
                model.addAttribute("teamRankEntryDTO", list.get(i));
            }
            log.info(list.get(i));
        }

        model.addAttribute("summonerDTO", summonerDTO);
        model.addAttribute("matchDTO", matchDTO);
        //model.addAttribute("comment", commentService.getList(summonerDTO.getPuuid()));
    }
}

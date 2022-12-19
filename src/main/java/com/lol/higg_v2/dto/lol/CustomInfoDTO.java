package com.lol.higg_v2.dto.lol;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomInfoDTO {
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
}

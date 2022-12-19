package com.lol.higg_v2.dto.lol;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MiniSeriesDTO {
    private int losses;
    private String progress;
    private int target;
    private int wins;
}

package com.lol.higg_v2.dto.lol;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PerkStyleDTO {

    private String description;
    private List<PerkStyleSelectionDTO> selections;
    private int style;

}

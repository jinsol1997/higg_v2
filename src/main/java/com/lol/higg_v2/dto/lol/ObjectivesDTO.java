package com.lol.higg_v2.dto.lol;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ObjectivesDTO {

    private ObjectiveDTO baron;
    private ObjectiveDTO champion;
    private ObjectiveDTO dragon;
    private ObjectiveDTO inhibitor;
    private ObjectiveDTO riftHerald;
    private ObjectiveDTO tower;
}

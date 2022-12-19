package com.lol.higg_v2.dto.lol;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatchDTO {

    private MetadataDTO metadata;
    private InfoDTO info;

}

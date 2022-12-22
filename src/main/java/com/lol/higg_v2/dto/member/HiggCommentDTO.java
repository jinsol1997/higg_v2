package com.lol.higg_v2.dto.member;

import com.lol.higg_v2.entity.HiggComment;
import com.lol.higg_v2.entity.HiggMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HiggCommentDTO {

    private Integer writer;

    private String reply;

    private String puuid;

    public HiggComment toCommentEntity(){
        return HiggComment.builder().writer(HiggMember.builder().idx(writer).build()).reply(reply).puuid(puuid).build();
    }
}

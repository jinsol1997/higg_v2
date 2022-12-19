package com.lol.higg_v2.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HiggCommentDTO {
    //댓글 DTO

    //댓글 작성한 아이디
    private String uid;
    //댓글을 작성한 게시물 롤닉네임
    private String puuid;
    //게시물에 작성한 댓글
    private String reply;
}

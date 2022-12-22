package com.lol.higg_v2.dto.member;

import com.lol.higg_v2.entity.HiggMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class HiggMemberDTO {

    private String uid;

    private String pw;

    public HiggMember toHiggMemberEntity(){
        return HiggMember.builder().uid(uid).pw(pw).role("USER").build();
    }
}

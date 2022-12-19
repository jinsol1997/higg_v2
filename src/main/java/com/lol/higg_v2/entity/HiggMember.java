package com.lol.higg_v2.entity;

import com.lol.higg_v2.dto.member.HiggLoginInfo;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "higg_member")
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class HiggMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idx;

    @Column
    private String uid;

    @Column
    private String pw;

    public HiggLoginInfo toLoginInfo() {
        return HiggLoginInfo.builder().uid(this.uid).build();
    }

}

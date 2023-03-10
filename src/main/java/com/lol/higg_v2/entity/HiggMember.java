package com.lol.higg_v2.entity;

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

    @Column
    private String role;

}

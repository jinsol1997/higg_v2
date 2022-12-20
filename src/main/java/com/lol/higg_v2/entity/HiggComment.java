package com.lol.higg_v2.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "higg_comment")
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HiggComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idx;

    @Column
    private String uid;

    @Column
    private String puuid;

    @Column
    private String reply;

    @Column(insertable = false, updatable = false)
    private LocalDate replydate;

    @Column(insertable = false)
    private LocalDate updatedate;
}

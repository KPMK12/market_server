package com.kpmk.market.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "mb_id")
    private Long id;
    private String mb_email;
    private String mb_pw;
    private String mb_name;

    @Embedded
    private Location location;
}
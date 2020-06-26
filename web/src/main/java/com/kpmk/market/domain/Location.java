package com.kpmk.market.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Location {

    @Id @GeneratedValue
    @Column(name = "location_id")
    private Long id;

    private String city;
    private String gu;
    private String dong;

    @OneToMany(mappedBy = "location")
    private List<Member> members = new ArrayList<Member>();
}
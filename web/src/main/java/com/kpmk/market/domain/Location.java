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
    private Long id;

    private String city_name;
    private String gu_name;
    private String dong_name;

    @OneToMany(mappedBy = "location")
    private List<Member> members = new ArrayList<Member>();
}
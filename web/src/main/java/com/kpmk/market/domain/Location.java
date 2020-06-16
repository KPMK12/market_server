package com.kpmk.market.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Location {

    private String city;
    private String gu;
    private String dong;

    protected Location(){
    }

    public Location(String city, String gu, String dong){
        this.city = city;
        this.gu = gu;
        this.dong = dong;
    }
}

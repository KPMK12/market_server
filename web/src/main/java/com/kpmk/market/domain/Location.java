package com.kpmk.market.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Location {

    private String city; //Seoul, Busan..etc..
    private String gu; //GangNam..etc..
    private String dong; //SinsaDong..etc..

    protected Location(){
    }

    public Location(String city, String gu, String dong){
        this.city = city;
        this.gu = gu;
        this.dong = dong;
    }
}

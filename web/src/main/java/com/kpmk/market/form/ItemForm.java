package com.kpmk.market.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemForm {
    public String title;
    public String description;
    public int price;
    public boolean priceOffer;
}

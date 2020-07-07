package com.kpmk.market.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String title;
    private String description;
    private int price;
    private boolean priceOffer;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @OneToMany
    @JoinColumn(name = "item_id")
    private List<File> itemPics = new ArrayList<File>();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    //private Category category : 향후 상품 Category 추가
}

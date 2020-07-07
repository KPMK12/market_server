package com.kpmk.market.repository;

import com.kpmk.market.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ItemReopsitory {

    private final EntityManager em;

    public void save(Item item){
        em.persist(item);
    }
}

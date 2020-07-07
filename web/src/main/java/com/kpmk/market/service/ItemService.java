package com.kpmk.market.service;

import com.kpmk.market.domain.Item;
import com.kpmk.market.repository.ItemReopsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemReopsitory itemReopsitory;

    @Transactional
    public Long itemReg(Item item){
        itemReopsitory.save(item);
        return item.getId();
    }
}

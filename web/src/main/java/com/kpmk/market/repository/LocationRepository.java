package com.kpmk.market.repository;

import com.kpmk.market.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LocationRepository {

    private final EntityManager em;

    public Location findOne(Long id){
        return em.find(Location.class, id);
    }

    public Location findByLocation(String city, String gu, String dong){
        return em.createQuery("select l from Location l where l.city = :city and l.gu = :gu and l.dong = :dong", Location.class)
                .setParameter("city",city)
                .setParameter("gu",gu)
                .setParameter("dong",dong)
                .getSingleResult();
    }

    public List<String> findAllCity(){
        return em.createQuery("select distinct l.city from Location l", String.class).getResultList();
    }

    public List<String> findAllGu(){
        return em.createQuery("select distinct l.gu from Location l", String.class).getResultList();
    }

    public List<String> findAllDong(){
        return em.createQuery("select distinct l.dong from Location l", String.class).getResultList();
    }
}

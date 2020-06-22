package com.kpmk.market.repository;

import com.kpmk.market.domain.Location;
import com.kpmk.market.domain.QLocation;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QLocation l = new QLocation("l");

        Location location = queryFactory.select(l).from(l).where(l.city.eq(city),l.gu.eq(gu),l.dong.eq(dong)).fetchOne();
        return location;
    }

    public List<String> findAllCity(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QLocation l = new QLocation("l");

        List<String> citys = queryFactory.select(l.city).distinct().from(l).fetch();
        return citys;
    }

    public List<String> findAllGu(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QLocation l = new QLocation("l");

        List<String> gus = queryFactory.select(l.gu).distinct().from(l).fetch();
        return gus;
    }

    public List<String> findAllDong(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QLocation l = new QLocation("l");

        List<String> dongs = queryFactory.select(l.dong).distinct().from(l).fetch();
        return dongs;
    }
}

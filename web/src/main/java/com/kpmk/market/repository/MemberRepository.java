package com.kpmk.market.repository;

import com.kpmk.market.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public Member findByUserId(String mb_email){
        return em.createQuery("select m from Member m where m.mb_email = :mb_email", Member.class).setParameter("mb_email", mb_email).getSingleResult();
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
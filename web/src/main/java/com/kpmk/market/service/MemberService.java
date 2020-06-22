package com.kpmk.market.service;

import com.kpmk.market.domain.Member;
import com.kpmk.market.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /** 회원가입 **/
    @Transactional
    public Long signup(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    public Member signin(String memberEmail, String memberPassword){
        Member member = memberRepository.findByUserId(memberEmail);
        if(member == null || !member.getPassword().equals(memberPassword)) return null;
        return member;
    }

    public void signout(HttpSession session) throws Exception{
        session.invalidate();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
}
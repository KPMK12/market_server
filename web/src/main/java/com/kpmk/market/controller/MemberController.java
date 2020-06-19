package com.kpmk.market.controller;

import com.kpmk.market.domain.Location;
import com.kpmk.market.domain.Member;
import com.kpmk.market.form.MemberForm;
import com.kpmk.market.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/signup")
    public String createForm(Model model){
        log.info("SIGNUP : GET");

        model.addAttribute("memberForm", new MemberForm());
        return "member/signup";
    }

    @PostMapping("/member/signup")
    public String signup(MemberForm form){
        log.info("SIGNUP : POST");

        Location location = new Location(form.getCity(), form.getGu(), form.getDong());

        Member member = new Member();
        member.setMb_email(form.mb_email);
        member.setMb_pw(form.mb_pw);
        member.setMb_name(form.mb_name);
        member.setLocation(location);

        memberService.signup(member);
        return "redirect:/";
    }

    @GetMapping("/member/signin")
    public String signin_info(Model model){
        log.info("SIGNIN : GET");
        model.addAttribute("memberForm", new MemberForm());
        return "member/signin";
    }

    @PostMapping("/member/signin")
    public String signin(MemberForm form, Model model, HttpServletRequest request){
        log.info("SIGNIN : POST");
        Member member = memberService.signin(form.getMb_email(), form.getMb_pw());
        HttpSession session = request.getSession();

        if(member != null){
            model.addAttribute("member", member);
            session.setAttribute("userid",member.getMb_email());
            return "main";
        }
        else return "redirect:/";
    }

    @GetMapping("/member/signout")
    public String signout(HttpSession session) throws Exception{
        log.info("SIGNOUT : GET");

        memberService.signout(session);

        return "redirect:/";
    }
}
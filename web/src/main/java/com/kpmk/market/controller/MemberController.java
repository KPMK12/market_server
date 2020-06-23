package com.kpmk.market.controller;

import com.kpmk.market.domain.Location;
import com.kpmk.market.domain.Member;
import com.kpmk.market.form.LocationForm;
import com.kpmk.market.form.MemberForm;
import com.kpmk.market.service.LocationService;
import com.kpmk.market.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final LocationService locationService;

    @GetMapping("/member/signup")
    public String signupInfo(Model model){
        log.info("SIGNUP : GET");

        model.addAttribute("memberForm", new MemberForm());
        return "member/signup";
    }

    @PostMapping("/member/signup")
    public String signup(MemberForm form){
        log.info("SIGNUP : POST");

        Member member = new Member();
        member.setEmail(form.email);
        member.setPassword(form.password);
        member.setName(form.name);

        memberService.signup(member);
        return "redirect:/";
    }

    @GetMapping("/member/signin")
    public String signinInfo(Model model){
        log.info("SIGNIN : GET");

        model.addAttribute("memberForm", new MemberForm());
        return "member/signin";
    }

    @PostMapping("/member/signin")
    public String signin(MemberForm form, Model model, HttpServletRequest request){
        log.info("SIGNIN : POST");

        Member member = memberService.signin(form.getEmail(), form.getPassword());
        HttpSession session = request.getSession();
        Location location = member.getLocation();

        if(member != null){
            model.addAttribute("member", member);
            session.setAttribute("userId", member.getId());
            session.setAttribute("userEmail", member.getEmail());
            if(location != null) {
                session.setAttribute("userCity", member.getLocation().getCity());
                session.setAttribute("userCity", member.getLocation().getGu());
                session.setAttribute("userCity", member.getLocation().getDong());
                return "main";
            } else return "redirect:/member/setlocation";
        }
        else return "redirect:/";
    }

    @GetMapping("/member/signout")
    public String signout(HttpSession session) throws Exception{
        log.info("SIGNOUT : GET");

        memberService.signout(session);
        return "redirect:/";
    }

    @GetMapping("/member/setlocation")
    public String createlocation(Model model){
        log.info("CREATELOCATION : GET");

        model.addAttribute("locationForm", new LocationForm());
        List<String> citys = locationService.findAllCity();
        List<String> gus = locationService.findAllGu();
        List<String> dongs = locationService.findAllDong();
        model.addAttribute("citys",citys);
        model.addAttribute("gus",gus);
        model.addAttribute("dongs",dongs);

        return "member/setlocation";
    }

    @PostMapping("/member/setlocation")
    public String setlocation(LocationForm form, Model model, HttpSession session){
        log.info("SETLOCATION : POST");

        Member member = memberService.findByUserId((String)session.getAttribute("userEmail"));
        Location location = locationService.findByLocation(form.city, form.gu, form.dong);
        member.setLocation(location);
        memberService.signup(member);

        session.setAttribute("userCity", location.getCity());
        session.setAttribute("userGu", location.getGu());
        session.setAttribute("userDong", location.getDong());
        return "main";
    }
}
package com.example.conquercrux.controller;


import com.example.conquercrux.domain.Member;
import com.example.conquercrux.service.member.LoginService;
import com.example.conquercrux.service.member.MemberRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @Autowired
    private LoginService loginService;

    // home 페이지이동
    @GetMapping({"","/home"})
    public String home() {
        return "home/home";
    }

    // 로그인 페이지이동
    @GetMapping("/login")
    public String showLoginPage() {
        return "home/login";
    }

    // 회원가입 페이지이동
    @GetMapping("/signup")
    public String showSignupPage() {
        return "home/signup";
    }

    // 마이페이지 이동
    @GetMapping("/mypage")
    public String showMyPage() {
        return "home/mypage";
    }

    // 회원가입 서비스
    @PostMapping("/register")
    public String registerMember(Member member) {
        memberRegisterService.registerMember(member);

        return "home/login";
    }

    // 로그인 서비스
    @PostMapping("/login")
    public String login(String member_id, String member_password) {

        if (loginService.checkCredentials(member_id, member_password)) {
           return "home";
        } else {
            return "login";
        }
    }

}

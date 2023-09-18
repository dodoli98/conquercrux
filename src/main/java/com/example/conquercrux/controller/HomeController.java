package com.example.conquercrux.controller;


import com.example.conquercrux.domain.Member;
import com.example.conquercrux.service.member.LoginService;
import com.example.conquercrux.service.member.MemberRegisterService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.Logger;

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
    public String login(String member_id, String member_password, HttpSession session) {

        if (loginService.checkCredentials(member_id, member_password) != null) {
            // 로그인 성공 시 세션에 ID 저장
            session.setAttribute("member_id", member_id);

            log.info("session member_id= {}", member_id);

            return "home/home";
        } else {
            return "home/login";
        }

    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 로그인 ID를 세션에서 제거합니다.
        String member_id = (String) session.getAttribute("member_id");
        session.removeAttribute("member_id");

        // 세션에 로그인 ID가 있는지 확인하는 로그를 작성합니다.
        if (member_id != null) {
            log.info("User with login ID {} logged out.", member_id);
        } else {
            log.info("Logout request, but user was not logged in.");
        }


        return "/home/home";
    }

}

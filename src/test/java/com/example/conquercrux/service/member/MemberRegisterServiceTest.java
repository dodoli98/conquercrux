package com.example.conquercrux.service.member;

import com.example.conquercrux.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberRegisterServiceTest {
    @Autowired
    private MemberRegisterService memberRegisterService;

    @Test
    public void testMemberRegisterServie() {
        Member member = new Member();

        member.setMember_id("2222");
        member.setMember_password("1234");
        member.setMember_name("홍길동");
        member.setMember_email("dodo@naber.com");
        member.setMember_phone_number("01022221111");
        member.setMember_address("서울");

        memberRegisterService.registerMember(member);

        log.info("member ={}", member);
    }

}
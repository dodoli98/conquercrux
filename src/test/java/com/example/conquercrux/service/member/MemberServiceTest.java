package com.example.conquercrux.service.member;

import com.example.conquercrux.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void testRead() {
        Member member = memberService.readMember("1234");
        log.info("Read Member = {}", member);
    }

    //----------------- UPDATE TEST -----------------

    @Test
    public void testUpdatePassword() {
        Member member = memberService.readMember("dodo");

        member.setMember_password("1234");
        memberService.updateMember(member);

    }

    @Test
    public void testUpdateName() {
        Member member = memberService.readMember("dodo");

        member.setMember_name("김철수");
        memberService.updateMember(member);

    }

    @Test
    public void testUpdatePhoneNumber() {
        Member member = memberService.readMember("dodo");

        member.setMember_phone_number("01099999999");
        memberService.updateMember(member);

    }

    @Test
    public void testUpdateEmail() {
        Member member = memberService.readMember("dodo");

        member.setMember_email("1234@naver.com");
        memberService.updateMember(member);
    }

    @Test
    public void testUpdateAddress() {
        Member member = memberService.readMember("1111");

        member.setMember_address("서울 용산구");
        memberService.updateMember(member);
    }

    //-----------------------------------------------



    @Test
    public void testDelete() {
        log.info("Delete member = {}", memberService.deleteMember("dodo"));
    }

    @Test
    public void testGetMemberList() {

        log.info("Print Member List = {}", memberService.getList());

    }

}
package com.example.conquercrux.mapper.member;

import com.example.conquercrux.domain.Member;
import com.example.conquercrux.mapper.member.MemberRegisterMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MemberRegisterMapperTest {

    @Autowired
    private MemberRegisterMapper registerMapper;

    @Test
    public void testMemberRegister() {
        Member member = new Member();

        member.setMember_id("dodo");
        member.setMember_password("1234");
        member.setMember_name("홍길동");
        member.setMember_email("dodo@naber.com");
        member.setMember_phone_number("01022221111");
        member.setMember_address("서울");


        registerMapper.registerMember(member);

        log.info("member ={}", member);

       }




}
package com.example.conquercrux.mapper.member;

import com.example.conquercrux.domain.Member;
import com.example.conquercrux.mapper.member.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class MemberMapperTest {
    @Autowired
    private MemberMapper mapper;

    @Test
    public void testRead() {
        Member member = mapper.readMember("1234");
        log.info("Read Member = {}", member);
    }

    //----------------- UPDATE TEST -----------------

    @Test
    public void testUpdatePassword() {
        Member member = mapper.readMember("dodo");

        member.setMember_password("1234");
        mapper.updateMember(member);

    }

    @Test
    public void testUpdateName() {
        Member member = mapper.readMember("dodo");

        member.setMember_name("김철수");
        mapper.updateMember(member);

    }

    @Test
    public void testUpdatePhoneNumber() {
        Member member = mapper.readMember("dodo");

        member.setMember_phone_number("01099999999");
        mapper.updateMember(member);

    }

    @Test
    public void testUpdateEmail() {
        Member member = mapper.readMember("dodo");

        member.setMember_email("1234@naver.com");
        mapper.updateMember(member);
    }

    @Test
    public void testUpdateAddress() {
        Member member = mapper.readMember("dodo");

        member.setMember_address("서울 용산구");
        mapper.updateMember(member);
    }

    //-----------------------------------------------



    @Test
    public void testDelete() {
        log.info("Delete member = {}", mapper.deleteMember("dodo"));
    }

    @Test
    public void testGetMemberList() {

        log.info("Print Member List = {}", mapper.getMember());

    }



}
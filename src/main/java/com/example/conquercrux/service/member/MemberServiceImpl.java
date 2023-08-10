package com.example.conquercrux.service.member;

import com.example.conquercrux.domain.Member;
import com.example.conquercrux.mapper.member.MemberMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    // 매퍼 주입
    private MemberMapper memberMapper;


    @Override
    public Member readMember(String member_id) {
        log.info("MemberService.readMember > member_id = {}", member_id);

        return memberMapper.readMember(member_id);
    }

    @Override
    public boolean updateMember(Member member) {
        log.info("MemberService.updateMember > member = {}", member);

        return memberMapper.updateMember(member) == 1;
    }

    @Override
    public boolean deleteMember(String member_id) {
        log.info("MemberService.deleteMember > member_id = {}", member_id);

        return memberMapper.deleteMember(member_id) == 1;
    }

    @Override
    public List<Member> getList() {
        log.info("MemberService.getList");

        return memberMapper.getMember();
    }
}

package com.example.conquercrux.service.member;

import com.example.conquercrux.domain.Member;
import com.example.conquercrux.mapper.member.MemberRegisterMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MemberRegisterServiceImpl implements MemberRegisterService {

    // 매퍼 주입
    private MemberRegisterMapper memberRegisterMapper;

    @Override
    public void registerMember(Member member) {
        log.info("MemberRegisterService > Registering a new member = {}", member);

        memberRegisterMapper.registerMember(member);
    }
}

package com.example.conquercrux.service.member;

import com.example.conquercrux.domain.Member;

public interface MemberRegisterService {
    /**
     * registerMember : 새로운 회원 정보 입력
     *
     * @param member    회원가입할 회원의 정보
     */
    void registerMember(Member member);
}

package com.example.conquercrux.mapper.member;

import com.example.conquercrux.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRegisterMapper {

    // 회원가입
    void registerMember(Member member);

}

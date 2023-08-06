package com.example.conquercrux.mapper.member;

import com.example.conquercrux.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    // 회원의 아이디를 통해 User 객체의 프로퍼티를 불러옴
    Member readMember(String member_id);

    // 회원 정보 변경
    int updateMember(Member member);

    // 회원 삭제
    int deleteMember(String member_id);


    // 테스트용 : 모든 회워 레코드 출력
    List<Member> getMember();

}

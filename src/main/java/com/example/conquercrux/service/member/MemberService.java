package com.example.conquercrux.service.member;


import com.example.conquercrux.domain.Member;

import java.util.List;

public interface MemberService {
    /**
     * READ: id를 통해 회원정보를 조회
     *
     * @param member_id 조회할 id
     */
    Member readMember(String member_id);

    /**
     * UPDATE: 회원정보 수정
     *
     * @param member    수정할 회원의 정보
     * @return          수정 여부
     */
    boolean updateMember(Member member);

    /**
     * DELETE: id를 통해 회원정보를삭제
     *
     * @param member_id  삭제할 회원의 id
     * @return           삭제 여부
     */
    boolean deleteMember(String member_id);

    /**
     * 모든 회원정보를 조회
     *
     * @return 모든 레코드
     */
    List<Member> getList();


}

package com.example.conquercrux.service.member;

public interface LoginService {
    /**
     * checkCredentials : 로그인 아이디와 비밀번호 일치여부
     *
     * @param member_id         로그인할 아이디
     * @param member_password   로그인할 아이디의 패스워드
     * @return                  로그인 성공여부
     */
    boolean checkCredentials(String member_id, String member_password);
}

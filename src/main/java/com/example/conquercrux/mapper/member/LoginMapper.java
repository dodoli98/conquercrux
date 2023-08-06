package com.example.conquercrux.mapper.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    // user_id 와 user_password 값을 확인해 로그인
    boolean checkCredentials(String member_id, String member_password);

}

package com.example.conquercrux.mapper.member;

import com.example.conquercrux.mapper.member.LoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LoginMapperTest {
    @Autowired
    private LoginMapper mapper;

    @Test
    public void testLogin() {

        log.info("login result= {}", mapper.checkCredentials("dodo", "dodo"));
    }

}
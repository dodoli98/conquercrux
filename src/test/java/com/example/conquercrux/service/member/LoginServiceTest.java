package com.example.conquercrux.service.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testLoginService() {

        loginService.checkCredentials("1111","1234");
    }


}
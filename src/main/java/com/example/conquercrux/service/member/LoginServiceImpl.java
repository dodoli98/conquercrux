package com.example.conquercrux.service.member;

import com.example.conquercrux.utils.JwtProvider;
import com.example.conquercrux.mapper.member.LoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final LoginMapper loginMapper;
    private final String key;
    private final Long expireTimeMs = 1000 * 60 * 60L;

    public LoginServiceImpl(LoginMapper loginMapper, @Value("${jwt.token.secret}") String key) {
        this.loginMapper = loginMapper;
        this.key = key;
    }

    @Override
    public String checkCredentials(String member_id, String member_password) {
        log.info("LoginServiceImpl.checkCredentials");

        // 사용자 정보 조회
        boolean loginResult = loginMapper.checkCredentials(member_id, member_password);

        // 로그인 결과가 참인 경우 토큰(String) 발행
        if (loginResult) {
            String token = JwtProvider.createToken(member_id, key, expireTimeMs);

            log.info(token);

            return token;
        } else {
            return null; // 로그인 실패 시 null 반환 또는 실패 상태를 나타내는 값을 반환.
        }
    }
}

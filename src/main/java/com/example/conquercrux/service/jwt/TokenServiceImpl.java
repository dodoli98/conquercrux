package com.example.conquercrux.service.jwt;

import com.example.conquercrux.jwt.JwtProvider;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TokenServiceImpl implements TokenService {

    private final String key;  // String 타입의 의존성 주입을 받을 필드 추가

    private Long expireTimeMs = 1000 * 60 * 60l;

    // 생성자 추가
    public TokenServiceImpl(@Value("${jwt.token.secret}") String key) {
        this.key = key;
    }

    @Override
    public String generateToken(String member_id) {
        return JwtProvider.createToken(member_id, key, expireTimeMs);
    }

    @Override
    public Claims validateToken(String token) {
        return JwtProvider.validateToken(token, key);
    }
}

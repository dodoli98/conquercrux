package com.example.conquercrux.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtProvider {

    public static String createToken(String member_id, String key, long expireTimeMs) {
        Date now = new Date(System.currentTimeMillis());

        Claims claims = Jwts.claims();
        claims.put("member_id", member_id);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))  // 토큰 발행 시간
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs)) // 토큰 만료시간
                .signWith(SignatureAlgorithm.HS256, key)  // 알고리즘 설정
                .compact();
    }

    public static Claims validateToken(String token, String key) {
        try {
            return Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            // 유효하지 않은 토큰인 경우 처리
            return null;
        }
    }

}
package com.example.conquercrux.service.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

public interface TokenService {

    String generateToken(String member_id);

    Claims validateToken(String token);

}

package com.example.restapi.service;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String secretKey = "f9fa3a09966ddcebf66f5ab679e3246748820aa80694b19d43b3cab49adf42ae";

    public String extractUserEmail(String jwt) {
        return null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSecret())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    private SecretKey getSecret() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}

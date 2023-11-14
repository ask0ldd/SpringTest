package com.example.restapi.service;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String secretKey = "f9fa3a09966ddcebf66f5ab679e3246748820aa80694b19d43b3cab49adf42ae";

    public String extractUserEmail(String token) {
        return extractClaim(token, Claims::getSubject); // !!! :: getSubject
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) { // !!! <T> T / Function <Claims, T>
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().claims(extraClaims).subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSecret(), SignatureAlgorithm.HS256).compact(); // !!! compact
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

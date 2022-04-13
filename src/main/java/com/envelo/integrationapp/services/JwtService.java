package com.envelo.integrationapp.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int dayInMillis;

    public String extractUsername(String token) {
        Claims claims = extractClaims(token);

        return claims.getSubject();
    }

    public Date extractExpirationDate(String token) {
        Claims claims = extractClaims(token);

        return claims.getExpiration();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = userDetails.getUsername();

        return !isTokenExpired(token) && extractUsername(token).equals(username);
    }

    public Boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date());
    }

    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey("fasfsafhgsdhsd")
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("user", userDetails.getUsername());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 86400))
                .signWith(SignatureAlgorithm.HS256, "fasfsafhgsdhsd")
                .addClaims(claims)
                .compact();
    }
}

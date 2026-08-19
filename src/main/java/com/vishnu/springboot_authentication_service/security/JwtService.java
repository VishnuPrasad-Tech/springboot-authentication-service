package com.vishnu.springboot_authentication_service.security;

import com.vishnu.springboot_authentication_service.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {
    private  final SecretKey signingKey;

    public JwtService(){
        String jwtSecret=System.getenv("JWT_SECRET");
        byte[] keyBytes= Decoders.BASE64.decode(jwtSecret);
        this.signingKey= Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                .signWith(signingKey)
                .compact();



    }
}

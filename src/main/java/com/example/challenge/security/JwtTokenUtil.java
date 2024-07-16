package com.example.challenge.security;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private String secret = "your-secret-key";
    private Algorithm algorithm;
    private JWTVerifier verifier;

    @PostConstruct
    public void init() {
        this.algorithm = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algorithm).build();
    }

    public String generateToken(UserDetails userDetails) {
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .sign(algorithm);
    }

    public String extractUsername(String token) {
        return decodeToken(token).getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            String username = decodedJWT.getSubject();
            return username.equals(userDetails.getUsername()) && !isTokenExpired(decodedJWT);
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public UsernamePasswordAuthenticationToken getAuthenticationToken(String token, UserDetails userDetails) {
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    private boolean isTokenExpired(DecodedJWT decodedJWT) {
        return decodedJWT.getExpiresAt().before(new Date());
    }

    private DecodedJWT decodeToken(String token) {
        return verifier.verify(token);
    }
}
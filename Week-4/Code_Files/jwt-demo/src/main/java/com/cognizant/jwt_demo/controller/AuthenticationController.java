package com.cognizant.jwt_demo.controller;

import io.jsonwebtoken.*;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.*;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        System.out.println("Authorization Header: " + authHeader);
        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decoded = new String(decodedBytes);
        String username = decoded.split(":")[0];
        return username;
    }

    private String generateJwt(String user) {
    	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        JwtBuilder builder = Jwts.builder()
            .setSubject(user)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 minutes
            .signWith(key);

        return builder.compact();
    }
}

package com.eventhub.gateway.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

/**
 * Util class to check if a token is 
 * valid not expired, or not tampered
 *
 */

@Component
public class JwtUtil {
	
	private final String SECRET = "supersecretkey";

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}

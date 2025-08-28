package com.J_RAS.J_RAS.security;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import java.util.Date;
@Component
public class JwtService {

    @Value("${JWT_SECRET}")
    private String secret;
    private final long EXPIRATION_TIME = 86400000;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }


    public String generarToken(String email, Long usuarioId) {
        return Jwts.builder()
                .setSubject(email) // sigue usando el email como "sub"
                .claim("usuarioId", usuarioId) // 👈 añadimos el ID del usuario
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    // 🔹 Obtener email desde el token
    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 🔹 Obtener usuarioId desde el token
    public Long getUsuarioIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("usuarioId", Long.class);
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

}



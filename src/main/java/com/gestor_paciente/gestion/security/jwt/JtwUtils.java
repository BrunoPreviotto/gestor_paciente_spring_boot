package com.gestor_paciente.gestion.security.jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.*;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;

@Component
@Slf4j
public class JtwUtils {

    @Value("$jwt.secret.key")
    private String secretKey;
    
    @Value("$jwt.time.expiration")
    private String timeExpiration;

    //GENERAR TOKEN DE ACCESO
    public  String generateAccesToken(String username, String email){
        
        Map<String, Object> extra = new HashMap<>();
        extra.put("usuarios" , username);
        
        return Jwts.builder()
                    .setSubject(email)
                    .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                    .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .addClaims(extra)
                    .compact();
                    

                    
    }

    //VALIDAR EL TOKEN DE ACCESO
    public boolean isTokenValid(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        } catch (Exception e) {
            log.error("Token invalido, error".concat(e.getMessage()));
            return false;
        }
    }

    public UsernamePasswordAuthenticationToken gAuthenticationToken(String token){
        
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (Exception e) {
            return null;
        }
    }


    //OBTENER USERNAME DEL TOKEN
    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }

    //OBTENER UN SOLO CLAIM
    public <T> T getClaim(String token, Function<Claims, T> claimsFuction){
        Claims claims = extractAllsClaims(token);
        return claimsFuction.apply(claims);
    }


    //OBTENER TODOS LOS CLAIMS(informacion del token) DEL TOKEN
    public Claims extractAllsClaims(String token){
        return Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
    }

    //OBTENER FIRMA DEL TOKEN
    public Key getSignatureKey(){
        byte[] keyByte = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyByte);
    }


}

package com.example.sb.service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	@Value("${jwt.expiration}")
	private long expiration;
	
	String secret = Base64.getEncoder().encodeToString(Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded());
	
	private Key getSignKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+ expiration))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
		
	}
	public String extractUserName(String token) {
		return Jwts.parser()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean ValidateToken(String token) {
		try {
			Jwts.parser().setSigningKey(getSignKey()).build().parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

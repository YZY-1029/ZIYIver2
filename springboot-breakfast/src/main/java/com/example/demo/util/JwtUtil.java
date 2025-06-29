//package com.example.demo.util;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.crypto.SecretKey;
//
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//@Component
//public class JwtUtil {
//	private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//	private final long expiration = 1000*60*30;
//	
//	public String generateToken(String userName, String role) {
//		Map<String, Object> claims = new HashMap<>();
//		claims.put("role", role);
//		
//		return Jwts.builder()
//				   .setClaims(claims)
//				   .setSubject(userName)
//				   .setIssuedAt(new Date())
//				   .setExpiration(new Date(System.currentTimeMillis() + expiration))
//				   .signWith(secretKey)
//				   .compact();
//	}
//	
//	public String extractUserName(String token) {
//		return Jwts.parserBuilder().setSigningKey(secretKey).build()
//				   .parseClaimsJws(token).getBody().getSubject();
//	}
//	
//	public String extractUserRole(String token) {
//		return (String) Jwts.parserBuilder().setSigningKey(secretKey).build()
//				   .parseClaimsJws(token).getBody().get("role");
//	}
//	
//	public boolean validateToken(String token) {
//		try {
//			Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
//			return true;
//		} catch (JwtException | IllegalArgumentException e) {
//			return false;
//		}
//	}
//
//}

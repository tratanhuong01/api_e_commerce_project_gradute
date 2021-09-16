//package com.api.api_e_commerce_project_gradute.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.Authentication;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//
//class TokenJwtUtil {
//  static final long EXPIRATION_TIME = 86_400_000; // 1 day
//  static final String SECRET = "demo";
//  static final String TOKEN_PREFIX = "Bearer";
//  static final String HEADER_STRING = "Authorization";
//
//  public static String generateJwt(String userId) {
////    long expirationTime = EXPIRATION_TIME;
////    return Jwts.builder()
////        .setId(userId)
////        .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
////        .signWith(SignatureAlgorithm.HS512, SECRET)
////        .compact();
//    return "";
//  }
//
//  public static Authentication getAuthentication(HttpServletRequest request) {
////    String token = request.getHeader(HEADER_STRING);
////    if (token != null) {
////      // parse the token
////      Claims claims = Jwts.parser()
////          .setSigningKey(SECRET)
////          .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
////          .getBody();
////      String userId = claims.getId();
////      return null;
////    }
//    return null;
//  }
//}
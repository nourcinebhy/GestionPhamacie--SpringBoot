package com.nourcine.backend.config;

import com.nourcine.backend.user.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final String  SECRET_Key= "509e8098e746012db803e9fb4e740c9c85d2dd7efa92f2c5c824de45a15d7997ae6e15a0c06c041119cc75e4cb04aba052ce7267516226370b45807ae1168eb9658f5e2444c8f312e8a441bebfbe7172b6317252a6ce55858f8faf451bed406dcd1ee60a401d0333751529e27206085e7924f6d617e9f37bb77bcdffafd06265235d7010ea2aafe9fd1bb7d1bbe3cfd000dad83cf2e8dbf81e1f78772a4217b29f29f42f29ae52a1d9d22bd003fe1fe1f810bbd3f14521a89a2d58b6440eacb945d8da3899ba60d563dbf955a37879138a1b3dc1425837cb8e3ba4e441ceb7a3c9286031e9546dff2eb53497c8cba4806933b5163f9d7c9aaa70dc120eff0248";

    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    public String generateToken(Map<String,Object>extractClaims,

                                UserDetails userDetails){
        String roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .claim("roles",roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60 *24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);


    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_Key);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
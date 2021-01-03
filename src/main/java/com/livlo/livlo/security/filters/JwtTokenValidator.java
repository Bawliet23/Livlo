package com.livlo.livlo.security.filters;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtTokenValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerauth = request.getHeader("Authorization");
        if (headerauth==null || headerauth.isEmpty() || !headerauth.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        try{
            String token = headerauth.replace("Bearer ","");
            String jwtSecret = "MohamedSecretKeyMohamedSecretKeyMohamedSecretKeyMohamedSecretKeyMohamedSecretKeyMohamedSecretKey";
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes())).build().parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            String subject = body.getSubject();
             var authorities = (List<Map<String,String>>) body.get("authorities");
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream().map(m -> new SimpleGrantedAuthority(m.get("authority"))).collect(Collectors.toList());
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    subject,
                    null,
                    simpleGrantedAuthorities
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (JwtException e){
             throw new IllegalStateException("Token cannot be trusted");
        }
        filterChain.doFilter(request,response);
    }
}

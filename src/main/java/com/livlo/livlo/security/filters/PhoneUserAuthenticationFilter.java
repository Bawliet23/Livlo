package com.livlo.livlo.security.filters;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.livlo.livlo.security.models.User;
import com.livlo.livlo.security.tokens.SmsCodeAuthenticationToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class PhoneUserAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final AuthenticationManager authenticationManager;
    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/login", "POST");
    public PhoneUserAuthenticationFilter(AuthenticationManager auth1) {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER);
        authenticationManager = auth1;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User myUserDetails = new ObjectMapper().readValue(request.getInputStream(), User.class);
           Authentication authentication= new SmsCodeAuthenticationToken(
                   myUserDetails.getPhone()
           );
            Authentication authenticate = authenticationManager.authenticate(authentication);
            if (authenticate.isAuthenticated()){
                System.out.println("**************************************************************** please ******************************************************");
            }
            return authenticate;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("hhh success");
        String jwtSecret = "MohamedSecretKeyMohamedSecretKeyMohamedSecretKeyMohamedSecretKeyMohamedSecretKeyMohamedSecretKey";
        String token =  Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities",authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusYears(5)))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
         response.addHeader("Authorization","Bearer "+token);

    }
}

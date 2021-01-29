package com.livlo.livlo.config;

import com.livlo.livlo.security.filters.JwtTokenValidator;
import com.livlo.livlo.security.filters.PhoneUserAuthenticationFilter;
import com.livlo.livlo.security.models.Roles;
import com.livlo.livlo.security.providers.SmsCodeAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SmsCodeAuthenticationProvider smsCodeAuthenticationProvider;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
                .addFilterAfter(new JwtTokenValidator(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/Auth/signIn","/Auth/signUp","index","/images/**","/css/**","/js/**").permitAll()
                .anyRequest().authenticated();

    }

   @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(smsCodeAuthenticationProvider);
    }



}

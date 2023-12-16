package com.fivetwenty.patienttracker.config;

import com.fivetwenty.patienttracker.util.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthFilter authFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login",
                        "/token",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/v3/api-docs",
                        "/webjars/**",
                        "/swagger-ui/**",
                        "/swagger/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(
                authFilter,
                UsernamePasswordAuthenticationFilter.class
        );

    }
}
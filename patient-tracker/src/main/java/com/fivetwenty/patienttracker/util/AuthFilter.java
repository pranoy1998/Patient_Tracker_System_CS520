package com.fivetwenty.patienttracker.util;

import com.fivetwenty.patienttracker.service.UserAccountService;
import com.fivetwenty.patienttracker.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String username = null;

        final String headerToken = request.getHeader("Authorization");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI();

        if (path.startsWith("/login") || path.equals("/v2/api-docs")) {
            filterChain.doFilter(request, response); // Bypass the filter
            return;
        }

        if (headerToken != null && headerToken.startsWith("Bearer ")) {
            String token = headerToken.substring(7);
            username = jwtTokenUtil.extractUsername(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userAccountService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(token)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                } else {
                    // Token is not valid
                }

            } else {
                // No userName in token.
            }
        } else {
            // No Auth header present exception.
        }

        filterChain.doFilter(request, response);

    }
}
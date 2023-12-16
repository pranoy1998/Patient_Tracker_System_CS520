package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.model.UserAccount;

import com.fivetwenty.patienttracker.util.CustomAuthManager;
import com.fivetwenty.patienttracker.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    CustomAuthManager customAuthManager;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserAccount authRequest) {
        try {
            Authentication authentication = customAuthManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            String token = JwtUtil.generateToken(authRequest.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            // Handle authentication failure (incorrect credentials)
            Map<String, String> response = new HashMap<>();
            response.put("Message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } catch (AuthenticationException e) {
            // Handle other authentication exceptions
            Map<String, String> response = new HashMap<>();
            response.put("Message", "Authentication failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}


package com.fivetwenty.patienttracker.util;

import static org.junit.jupiter.api.Assertions.*;

import com.fivetwenty.patienttracker.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {

    @Test
    public void testGenerateToken() {
        String token = JwtUtil.generateToken("testUser");
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    public void testExtractUsername() {
        String token = JwtUtil.generateToken("testUser");
        String extractedUsername = JwtUtil.extractUsername(token);
        assertEquals("testUser", extractedUsername);
    }

    @Test
    public void testValidateTokenWithValidToken() {
        String token = JwtUtil.generateToken("testUser");
        assertTrue(JwtUtil.validateToken(token));
    }

    @Test
    public void testValidateTokenWithInvalidToken() {
        String invalidToken = "invalidToken";
        assertFalse(JwtUtil.validateToken(invalidToken));
    }


}

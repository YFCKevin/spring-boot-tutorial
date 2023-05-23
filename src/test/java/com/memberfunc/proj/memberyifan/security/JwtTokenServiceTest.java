package com.memberfunc.proj.memberyifan.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JwtTokenServiceTest {
    @Autowired
    private JwtTokenService jwtTokenService;

    @BeforeEach
    public void setUp() {
        jwtTokenService = new JwtTokenService();
    }

    @Test
    public void testGenerateToken() {
        String subject = "user123";
        Long ttlMillis = 3600000L; // 1 hour
        String uuid = "123456789";

        String token = jwtTokenService.generate(subject, ttlMillis, uuid);
        Assertions.assertNotNull(token);
    }
}

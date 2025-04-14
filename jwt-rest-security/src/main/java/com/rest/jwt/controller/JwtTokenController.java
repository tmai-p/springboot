package com.rest.jwt.controller;

import com.rest.jwt.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class JwtTokenController {

    private JwtEncoder jwtEncoder;
    private TokenService tokenService;

    public JwtTokenController(JwtEncoder jwtEncoder, TokenService tokenService) {
        this.jwtEncoder = jwtEncoder;
        this.tokenService = tokenService;
    }
    private static final Logger log = LoggerFactory.getLogger(JwtTokenController.class);

    @PostMapping("/token")
    public String getToken(Authentication authentication) {
        String token = tokenService.tokenGen(authentication);
        log.info("Token granted");
        return token;
    }
}

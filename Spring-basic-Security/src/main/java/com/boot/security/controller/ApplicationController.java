package com.boot.security.controller;


import com.boot.security.dto.AuthRequest;
import com.boot.security.service.JwtService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/getMsg")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
     public String greeting() {
         return "hello";
     }

    @GetMapping("/getMsg1")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String wish() {
        return "hi";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated())
            return jwtService.generateToken(authRequest.getUsername());
        else throw new UsernameNotFoundException("User not found");


    }
}

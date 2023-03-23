package com.boot.security.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

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
}

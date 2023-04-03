package com.boot.security.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthRequest {
    private String username;
    private String password;
}

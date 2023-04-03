package com.spring.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "USER_TABLE")
public class User {

    @Id
    private int id;
    private String username;
    private String email;
    private String password;
}

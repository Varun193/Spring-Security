package com.boot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    //default spring security
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authz) -> authz
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }

//    //security based URL
//    @Bean
//    public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/rest/**")
//                .fullyAuthenticated().and().httpBasic();
//        return http.build();
//    }

    //Role based Security

        @Bean
    public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/rest/**")
                .hasAnyRole("USER")
                .anyRequest()
                .fullyAuthenticated().and().httpBasic();
        return http.build();
    }


    //In-Memory Authentication
    @Bean
    public InMemoryUserDetailsManager UserDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("varun")
                .password("12345")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
//    @Bean
//    public InMemoryUserDetailsManager UserDetailsService1() {
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("megha")
//                .password("54321")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1);
//    }

}
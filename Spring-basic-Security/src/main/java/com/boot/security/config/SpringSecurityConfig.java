package com.boot.security.config;

import com.boot.security.service.UserInfoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
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
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/noAuth/**","/user/new").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/rest/**")
//                .hasAnyRole("ADMIN")
//                .anyRequest()
                .fullyAuthenticated().and().httpBasic();
        return http.build();
    }


    // Create User details Using UserDetailsService(provided by spring-security) interface and store in
    //InMemoryUserDetailsManager
    @Bean
    public UserDetailsService userDetails(PasswordEncoder pwdEncoder) {
    //        UserDetails admin = User.withUsername("Meghana")
    //                .password(pwdEncoder.encode("54321"))
    //                .roles("ADMIN")
    //                .build();
    //        UserDetails user = User.withUsername("Varun")
    //                .password(pwdEncoder.encode("12345"))
    //                .roles("USER")
    //                .build();
    //        return new InMemoryUserDetailsManager(admin,user);
        return new UserInfoUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
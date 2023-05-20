package com.practice2.practice2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.w3c.dom.UserDataHandler;

import java.net.http.HttpRequest;
import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration

public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){


        UserDetails userDetails = createNewUser("khan", "khan12");
        UserDetails userDetails1 = createNewUser("admin", "khan12");
        return  new InMemoryUserDetailsManager(userDetails,userDetails1);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder=
                input-> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
//                .username("khan")
//                .password(passwordEncoder().encode("khan12"))
                .username(username)
                .password(password)
                .roles("ADMIN", "USER")
                .build();
        return userDetails;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(
                auth -> auth.anyRequest().authenticated() );;
                http.formLogin(withDefaults());
                http.csrf().disable();
                http.headers().frameOptions().disable();
                return http.build();

    }
}

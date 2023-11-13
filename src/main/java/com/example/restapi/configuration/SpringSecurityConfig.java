package com.example.restapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // h2-console urls and users endpoint are not protected
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"),
                new AntPathRequestMatcher("/users/**"), new AntPathRequestMatcher("/user/**"),
                new AntPathRequestMatcher("/login/**"));
    }
}
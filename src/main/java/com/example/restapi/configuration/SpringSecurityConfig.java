package com.example.restapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    /*
     * @Bean
     * public WebSecurityCustomizer webSecurityCustomizer() {
     * // h2-console urls and users endpoint are not protected
     * return (web) -> web.ignoring().requestMatchers(new
     * AntPathRequestMatcher("/h2-console/**"),
     * new AntPathRequestMatcher("/users/**"), new
     * AntPathRequestMatcher("/user/**"),
     * new AntPathRequestMatcher("/login/**"));
     * }
     */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> {
            /*
             * auth.requestMatchers("/user/**").hasRole("USER");
             * auth.requestMatchers("/users").permitAll();
             * auth.requestMatchers("/h2-console/**").permitAll();
             */
            auth.requestMatchers(new AntPathRequestMatcher("/admin")).hasRole("ADMIN");
            auth.requestMatchers(new AntPathRequestMatcher("/user/**")).permitAll()/* .hasRole("USER") */;
            auth.requestMatchers(new AntPathRequestMatcher("/users")).permitAll();
            auth.anyRequest().authenticated();

            // auth.anyRequest().permitAll();
        }).build();
    }

    /*
     * Spring Security comprend une configuration par défaut qui la rend
     * immédiatement sécurisée. Ainsi, même si en réalité aucune configuration
     * personnalisée n’a été codée dans la méthode, la chaîne de filtre est dors et
     * déjà opérationnelle.
     * 
     * Cette configuration définit entre autres les éléments suivants :
     * 
     * Cache-Control: no-cache, no-store, max-age=0, must-revalidate
     * Pragma: no-cache
     * Expires: 0
     * X-Content-Type-Options: nosniff
     * Strict-Transport-Security: max-age=31536000 ; includeSubDomains
     * X-Frame-Options: DENY
     * X-XSS-Protection: 1; mode=block
     * 
     * https://openclassrooms.com/fr/courses/7137776-securisez-votre-application-web
     * -avec-spring-security/7275506-configurez-un-controle-d-acces-base-sur-les-
     * roles#/id/r-7276338
     */
}

/*
 * http
 * .requestMatchers()
 * .antMatchers("/management/") // Define the URL pattern
 * .and()
 * .authorizeRequests()
 * .antMatchers("/management/health").permitAll() // Define authorization rules
 * .antMatchers("/management/info").permitAll()
 * .antMatchers("/management/").hasRole("ACTUATOR")
 * .anyRequest().permitAll()
 * .and()
 * .httpBasic();
 */
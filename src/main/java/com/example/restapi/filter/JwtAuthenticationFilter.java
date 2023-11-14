package com.example.restapi.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                final String authHeader = request.getHeader("Authorization");
                final String jwt;
                if(authHeader == null || !authHeader.startsWith("Bearer ")){
                    filterChain.doFilter(request, response);
                    return;
                }
                jwt = authHeader.substring(7);
    }

}

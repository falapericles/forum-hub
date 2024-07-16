package com.example.challenge.filter;

import com.example.challenge.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.example.challenge.service.UserService;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public JwtTokenFilter(UserService userService, JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Implementação do filtro JWT
        filterChain.doFilter(request, response);
    }
}

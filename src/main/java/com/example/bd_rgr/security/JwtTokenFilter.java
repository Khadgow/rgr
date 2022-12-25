package com.example.bd_rgr.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtTokenFilter extends GenericFilterBean {
    private final JwtTokenProvider jwtTokenProvider;
    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String bearerToken  = jwtTokenProvider.resolveToken((HttpServletRequest) servletRequest);
        try {
            if (bearerToken != null) {
                String[] splitHeader = bearerToken .split(" ");
                if(splitHeader.length != 2 || !Objects.equals(splitHeader[0], "Bearer")){
                    throw new JwtAuthenticationException("JWT token is expired or invalid");
                }
                String token = splitHeader[1];
                if (token != null && jwtTokenProvider.validateToken(token)) {
                    Authentication authentication = jwtTokenProvider.getAuthentication(token);
                    if (authentication != null) {
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }

        } catch (JwtAuthenticationException e) {
            SecurityContextHolder.clearContext();
            ((HttpServletResponse) servletResponse).sendError(e.getHttpStatus().value());
            throw new JwtAuthenticationException("JWT token is expired or invalid");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

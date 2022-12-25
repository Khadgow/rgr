package com.example.bd_rgr.service;

import com.example.bd_rgr.dto.Token;
import com.example.bd_rgr.dto.LoginDTO;
import com.example.bd_rgr.dto.UserRegisterDTO;
import com.example.bd_rgr.entity.storeDirection.RoleEntity;
import com.example.bd_rgr.entity.storeDirection.UserEntity;
import com.example.bd_rgr.repository.storeDirection.RoleRepo;
import com.example.bd_rgr.repository.storeDirection.UserRepo;
import com.example.bd_rgr.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private UserRepo userRepository;
    private JwtTokenProvider jwtTokenProvider;

    private PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepository;

    public AuthenticationService(AuthenticationManager authenticationManager, UserRepo userRepository, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder, RoleRepo roleRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public Token login(LoginDTO request) {
        var userPas = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        authenticationManager.authenticate(userPas);
        UserEntity user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
        String token = jwtTokenProvider.createToken(request.getEmail(), user.getRoles());
        var answer = new Token();
        answer.setToken(token);
        return answer;
    }

    public UserEntity getMe(String token) {
        jwtTokenProvider.validateToken(token);
        var email = jwtTokenProvider.getUsername(token);
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));

    }

    public Token register(UserRegisterDTO request) {
        if (userRepository.findByEmail(request.getEmail()).orElse(null) != null || userRepository.findByUsername(request.getUsername()).orElse(null) != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");
        }
        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        List<RoleEntity> userRoles = new ArrayList<>();
        var role = roleRepository.findByName("USER");
        userRoles.add(role);
        user.setRoles(userRoles);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        String token = jwtTokenProvider.createToken(request.getEmail(), user.getRoles());
        var answer = new Token();
        answer.setToken(token);
        return answer;
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}

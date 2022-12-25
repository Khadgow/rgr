package com.example.bd_rgr.controller;

import com.example.bd_rgr.dto.Token;
import com.example.bd_rgr.dto.LoginDTO;
import com.example.bd_rgr.dto.UserRegisterDTO;
import com.example.bd_rgr.entity.storeDirection.UserEntity;
import com.example.bd_rgr.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Token> authenticate(@RequestBody UserRegisterDTO request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<Token> authenticate(@RequestBody LoginDTO request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("/getMe")
    public ResponseEntity<UserEntity> getMe(@RequestHeader Map<String, String> headers) {
        var header = headers.get("authorization");
        if(header == null || header.split(" ").length != 2) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        var token = header.split(" ")[1];
        return ResponseEntity.ok(authenticationService.getMe(token));
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        authenticationService.logout(request, response);
    }
}

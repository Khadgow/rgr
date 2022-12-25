package com.example.bd_rgr.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UserCreateDTO {
    private String username;
    private String email;
    private String password;
    private ArrayList<Integer> roles;
}

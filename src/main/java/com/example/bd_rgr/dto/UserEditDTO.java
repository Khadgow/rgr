package com.example.bd_rgr.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class UserEditDTO {
    private String username;
    private String email;
    private ArrayList<Integer> roles;
}

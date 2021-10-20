package com.example.myapplication.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String email;
    private String firstName;
    private String secondName;
    private String phone;
    private String photo;
    private String password;
    private String confirmPassword;

    public RegisterDTO() {
    }

    public RegisterDTO(String email, String firstName, String secondName,
                       String phone, String photo, String password,
                       String confirmPassword) {
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.photo = photo;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
package com.judyprograms.temperthestorm.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;

@Validated
public class UserRequestDto {

    @NotBlank
    public String username;

    @NotBlank
    @Email
    public String email;

    @NotBlank
    @Size(min=6, max=30)
    public String password;

    public List<String> authorities;


//    GETTERS & SETTERS

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}





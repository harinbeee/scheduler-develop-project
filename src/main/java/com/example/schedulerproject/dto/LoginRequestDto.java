package com.example.schedulerproject.dto;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
public class LoginRequestDto {

    @NotNull
    private final String mail;

    @NotNull
    private final String password;

    public LoginRequestDto(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
}

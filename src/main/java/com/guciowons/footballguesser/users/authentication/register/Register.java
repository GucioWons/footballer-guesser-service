package com.guciowons.footballguesser.users.authentication.register;

public class Register {
    private final String username;
    private final String email;
    private final String password;

    public Register(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
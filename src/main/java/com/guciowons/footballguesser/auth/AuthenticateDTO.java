package com.guciowons.footballguesser.auth;

public record AuthenticateDTO(String username, String email, String password, String token) {
}

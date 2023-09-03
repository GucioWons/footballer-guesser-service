package com.guciowons.footballguesser.auth.dto;

public record UserResponseDTO(String email, String username, String password, String token) {
}

package com.security.domain.user;

public record RegisterDto(
        String login,
        String password,
        UserRole role
) {
}

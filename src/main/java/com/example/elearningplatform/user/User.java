package com.example.elearningplatform.user;


public record User(String login,
                   String password,
                   String email,
                   Role role) {
}

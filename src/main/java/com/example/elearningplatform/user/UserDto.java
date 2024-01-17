package com.example.elearningplatform.user;


public record UserDto(String login,
                      String password,
                      String email,
                      Role role) {
}

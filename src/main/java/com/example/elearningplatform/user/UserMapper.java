package com.example.elearningplatform.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto map(UserEntity entity) {
        return new UserDto(entity.getLogin(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getRole());
    }

    public UserDto mapExcludedPassword(UserEntity entity) {
        return new UserDto(entity.getLogin(),
                "????",
                entity.getEmail(),
                entity.getRole());
    }

    public UserEntity map(UserDto dto) {
        return UserEntity.builder()
                .login(dto.login())
                .password(dto.password())
                .email(dto.email())
                .role(dto.role())
                .build();
    }
}

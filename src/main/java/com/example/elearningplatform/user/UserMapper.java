package com.example.elearningplatform.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder encoder;
    public UserDto map(UserEntity entity) {
        return new UserDto(entity.getLogin(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getRole());
    }

    public UserDto mapEncodePassword(UserEntity entity) {
        return new UserDto(entity.getLogin(),
                encoder.encode(entity.getPassword()),
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

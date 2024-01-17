package com.example.elearningplatform.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    UserDto map(UserEntity entity) {
        return new UserDto(entity.getLogin(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getRole());
    }
    UserDto mapExcludedPassword(UserEntity entity) {
        return new UserDto(entity.getLogin(),
                "????",
                entity.getEmail(),
                entity.getRole());
    }

}

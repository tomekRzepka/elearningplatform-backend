package com.example.elearningplatform.user;

import com.example.elearningplatform.exception.ElearningPlatformException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;


    public List<UserDto> getAllUsers() {
        return repository.findAll().stream()
                .map(userMapper::map)
                .toList();
    }

    public void addUser(UserDto user) {
        repository.save(userMapper.map(user));
    }

    public Boolean editUser(UserDto user) {
        Optional<UserEntity> entity = repository.findByLogin(user.login());
        if (entity.isPresent()) {
            UserEntity userEntity = entity.get();
            userEntity.setPassword(user.password() != null ? user.password() : userEntity.getPassword());
            userEntity.setEmail(user.email() != null ? user.email() : userEntity.getEmail());
            userEntity.setRole(user.role() != null ? user.role() : userEntity.getRole());
            repository.save(userEntity);
            return true;
        }
        return false;
    }

    public UserDto getUser(String login) {
        return repository.findByLogin(login)
                .map(userMapper::map)
                .orElseThrow(() -> new ElearningPlatformException("User not found"));
    }

    public void removeUser(String login) {
        repository.deleteByLogin(login);
    }

    public UserDto userValidation(UserDto user) {
        return repository.findByLogin(user.login())
                .filter(entity -> entity.getPassword().equals(user.password()))
                .map(userMapper::mapEncodePassword)
                .orElseThrow(() -> new ElearningPlatformException("User not found"));
    }

    public UserEntity getUserEntity(String login) {
        return repository.findByLogin(login)
                .orElseThrow(() -> new ElearningPlatformException("User not found"));
    }
}

package com.example.elearningplatform.user;

import com.example.elearningplatform.ElearningPlatformException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public List<User> getAllUsers() {
        return repository.findAll().stream()
                .map(entity -> new User(entity.getLogin(),
                        entity.getPassword(),
                        entity.getEmail(),
                        entity.getRole()))
                .toList();
    }

    public void addUser(User user) {
        repository.save(UserEntity.builder()
                .login(user.login())
                .password(user.password())
                .email(user.email()).role(Role.CUSTOMER)
                .build());
    }

    public Boolean editUser(User user) {
        Optional<UserEntity> entity = repository.findByLogin(user.login());
        if (entity.isPresent()) {
            UserEntity userEntity = entity.get();
            userEntity.setPassword(user.password());
            userEntity.setEmail(user.email());
            userEntity.setRole(user.role());
            repository.save(userEntity);
            return true;
        }
        return false;
    }

    public User getUser(String login) {
        return repository.findByLogin(login)
                .map(entity -> new User(entity.getLogin(),
                        entity.getPassword(),
                        entity.getEmail(),
                        entity.getRole()))
                .orElseThrow(() -> new ElearningPlatformException("User not found"));
    }

    public void removeUser(String login) {
        repository.deleteByLogin(login);
    }

    public User userValidation(String login) {
        return repository.findByLogin(login)
                .map(entity -> new User(entity.getLogin(),
                        "????",
                        entity.getEmail(),
                        entity.getRole()))
                .orElseThrow(() -> new ElearningPlatformException("User not found"));
    }
}

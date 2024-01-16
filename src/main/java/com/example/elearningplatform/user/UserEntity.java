package com.example.elearningplatform.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String login;
    String password;
    String email;
    Role role;

    public UserEntity() {
        this.login = "test";
        this.password = "test";
        this.email = "test@test.com";
        this.role = Role.CUSTOMER;
    }
}

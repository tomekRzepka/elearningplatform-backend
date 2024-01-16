package com.example.elearningplatform.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name="content")
@Data
class ContentEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String description;
    String link;
}

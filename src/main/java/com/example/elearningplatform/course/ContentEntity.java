package com.example.elearningplatform.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name="content")
@Data
@Builder
@AllArgsConstructor
class ContentEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String description;
    String link;


    public ContentEntity() {
        this.description="test";
        this.link="test link";
    }
}

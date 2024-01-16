package com.example.elearningplatform.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}

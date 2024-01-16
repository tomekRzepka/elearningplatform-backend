package com.example.elearningplatform.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ContentRepository extends JpaRepository<ContentEntity,Long> {
}

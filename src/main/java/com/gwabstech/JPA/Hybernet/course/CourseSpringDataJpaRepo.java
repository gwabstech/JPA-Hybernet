package com.gwabstech.JPA.Hybernet.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepo extends JpaRepository<Course,Long> {

    List<Course> findByAuthor(String author);

}

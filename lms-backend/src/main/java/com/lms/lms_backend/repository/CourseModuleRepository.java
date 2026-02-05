package com.lms.lms_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.lms_backend.entity.CourseModule;

public interface CourseModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findByCourseId(Long courseId);

    CourseModule save(CourseModule module);
}

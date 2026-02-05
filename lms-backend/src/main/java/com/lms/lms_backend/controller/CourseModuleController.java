package com.lms.lms_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.lms_backend.entity.Course;
import com.lms.lms_backend.entity.CourseModule;
import com.lms.lms_backend.repository.CourseRepository;
import com.lms.lms_backend.repository.CourseModuleRepository;

@RestController
@RequestMapping("/api/modules")
@CrossOrigin
public class CourseModuleController {

    @Autowired
    private CourseModuleRepository moduleRepository;

    @Autowired
    private CourseRepository courseRepository;

   @PostMapping("/{courseId}")
public CourseModule addModule(
        @PathVariable Long courseId,
        @RequestBody CourseModule module
) {
    Course course = courseRepository.findById(courseId).orElseThrow();
    module.setCourse(course);
    return moduleRepository.save(module);
}

    

    @GetMapping("/course/{courseId}")
    public List<Module> getModulesByCourse(@PathVariable Long courseId) {
        return moduleRepository.findByCourseId(courseId);
    }
}

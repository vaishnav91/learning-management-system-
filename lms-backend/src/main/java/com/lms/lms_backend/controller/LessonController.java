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

import com.lms.lms_backend.entity.Lesson;
import com.lms.lms_backend.repository.CourseModuleRepository;
import com.lms.lms_backend.repository.LessonRepository;

@RestController
@RequestMapping("/api/lessons")
@CrossOrigin
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseModuleRepository moduleRepository;

    @PostMapping("/{moduleId}")
    public Lesson addLesson(@PathVariable Long moduleId, @RequestBody Lesson lesson) {
        Module module = moduleRepository.findById(moduleId).orElseThrow();
        lesson.setModule(module);
        return lessonRepository.save(lesson);
    }

    @GetMapping("/module/{moduleId}")
    public List<Lesson> getLessons(@PathVariable Long moduleId) {
        return lessonRepository.findByModuleId(moduleId);
    }
}

package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.Course;
import java.util.List;

public interface CourseService {

    Course createCourse(Course course);

    List<Course> getAllCourses();
}

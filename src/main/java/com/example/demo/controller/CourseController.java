package com.example.demo.controller;

import com.example.demo.model.dto.course.*;
import com.example.demo.model.dto.lesson.LessonGetDTO;
import com.example.demo.model.dto.lesson.LessonPostDTO;
import com.example.demo.service.CourseService;
import com.example.demo.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;
    private LessonService lessonService;

    @PostMapping("/courses")
    public CourseGetDTO postCourse(@RequestBody CoursePostDTO coursePostDTO){
        return courseService.insertCourse(coursePostDTO);
    }

    @PutMapping("/courses/{id}")
    public CourseGetDTO putCourse(@PathVariable Long id, @RequestBody CoursePutDTO coursePutDTO){
        return courseService.putCourse(id, coursePutDTO);
    }

    @PostMapping("courses/{courseId}/enrollments")
    public CourseGetUserDto postUserCourse(@PathVariable Long courseId, @RequestBody CoursePostUserDTO coursePostUserDTO){
        return courseService.postUserCourse(courseId, coursePostUserDTO);
    }

    @PostMapping("courses/{courseId}/lessons")
    public LessonGetDTO insertLesson(@PathVariable Long courseId, @RequestBody LessonPostDTO lessonPostDTO){
        return lessonService.insertLesson(courseId, lessonPostDTO);
    }
}

package com.example.demo.service;

import com.example.demo.model.dto.lesson.LessonGetDTO;
import com.example.demo.model.dto.lesson.LessonPostDTO;
import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Lesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LessonRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LessonService {
    private ModelMapper modelMapper;
    private LessonRepository lessonRepository;
    private CourseRepository courseRepository;

    public LessonGetDTO insertLesson(Long courseId, LessonPostDTO lessonPostDTO){
        LessonGetDTO lessonGetDTO = new LessonGetDTO();
        Lesson lesson = new Lesson();
        Course course = courseRepository.findById(courseId).get();
        lesson.setCourse(course);
        modelMapper.map(lessonPostDTO, lesson);
        lessonRepository.save(lesson);
        modelMapper.map(lesson, lessonGetDTO);
        return lessonGetDTO;
    }
}

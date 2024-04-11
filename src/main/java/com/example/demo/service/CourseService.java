package com.example.demo.service;

import com.example.demo.model.dto.course.*;
import com.example.demo.model.entity.Certificate;
import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Enrollment;
import com.example.demo.model.entity.User;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentsRepository;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;
    private CertificateRepository certificateRepository;
    private EnrollmentsRepository enrollmentsRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    public CourseGetDTO insertCourse(CoursePostDTO coursePostDTO){
        Course course = new Course();
        CourseGetDTO courseGetDTO = new CourseGetDTO();
        modelMapper.map(coursePostDTO, course);
        courseRepository.save(course);
        modelMapper.map(course, courseGetDTO);

        return courseGetDTO;
    }

    public CourseGetDTO putCourse(Long id, CoursePutDTO CoursePutDTO){
        Course course = courseRepository.findById(id).get();
        CourseGetDTO courseGetDTO = new CourseGetDTO();
        modelMapper.map(CoursePutDTO, course);
        modelMapper.map(course, courseGetDTO);
        courseRepository.save(course);
        return courseGetDTO;
    }

    public CourseGetUserDto postUserCourse(Long courseId, CoursePostUserDTO coursePostUserDTO){
        CourseGetUserDto courseGetUserDto = new CourseGetUserDto();
        Course course = courseRepository.findById(courseId).get();
        User user = userRepository.findById(coursePostUserDTO.getUserId()).get();
        Certificate certificate = new Certificate("Ta terminado");

        Enrollment enrollment = new Enrollment();

        enrollment.setCourse(course);
        enrollment.setUser(user);

        user.setCertificates(certificate);
        certificateRepository.save(certificate);
        enrollmentsRepository.save(enrollment);
        modelMapper.map(enrollment, courseGetUserDto);

        courseGetUserDto.setName(user.getName());
        courseGetUserDto.setTitle(course.getTitle());

        return courseGetUserDto;
    }
}

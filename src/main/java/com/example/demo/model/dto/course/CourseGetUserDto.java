package com.example.demo.model.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseGetUserDto {
    private Long id;
    private String name;
    private Long courseId;
    private String title;
    private LocalDateTime registrationDate;
}
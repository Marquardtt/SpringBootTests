package com.example.demo.model.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseGetDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
}
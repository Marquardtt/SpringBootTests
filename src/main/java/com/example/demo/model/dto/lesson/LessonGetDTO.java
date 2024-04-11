package com.example.demo.model.dto.lesson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LessonGetDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime publicationDate;
}

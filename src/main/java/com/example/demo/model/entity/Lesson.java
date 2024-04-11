package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime publicationDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Course course;

    public Lesson(){
        this.setPublicationDate(LocalDateTime.now());
    }
}
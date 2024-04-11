package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Collection;
@Data
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Instructor instructor;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Lesson> lessons;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Enrollment> enrollments;

    public Course(){
        this.setCreationDate(LocalDateTime.now());
    }
}
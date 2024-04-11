package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specializationArea;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Course> courses;
}
package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private LocalDateTime issueDate;
    @OneToOne
    private User user;

    public Certificate(String courseName){
        this.setIssueDate(LocalDateTime.now());
        this.setCourseName(courseName);
    }
}
package com.example.demo.model.entity;

import com.example.demo.model.EnrollmentId;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@Entity
public class Enrollment {
    @EmbeddedId
    private EnrollmentId enrollmentId = new EnrollmentId();
    private LocalDateTime registrationDate;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId("id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId("courseId")
    private Course course;

    public Enrollment(){
        this.setRegistrationDate(LocalDateTime.now());
    }
}
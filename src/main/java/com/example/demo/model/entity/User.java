package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Collection;
@Data
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime registrationDate;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Course> courses;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Certificate> certificates;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Enrollment> enrollments;

    public User(){
        this.setRegistrationDate(LocalDateTime.now());
    }

    public void setCertificates(Certificate certificate) {
        this.certificates.add(certificate);
    }
}
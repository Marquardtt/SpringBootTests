package com.example.demo.repository;

import com.example.demo.model.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentsRepository extends JpaRepository<Enrollment, Long> {


}

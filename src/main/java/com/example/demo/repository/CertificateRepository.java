package com.example.demo.repository;

import com.example.demo.model.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    Collection<Certificate> findAllByUserId(Long id);
}

package com.example.demo.service;

import com.example.demo.model.dto.certificate.CertificateGetDTO;
import com.example.demo.model.entity.Certificate;
import com.example.demo.repository.CertificateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class CertificateService {
    private CertificateRepository certificateRepository;

    public Collection<Certificate> getAll(Long id){
        return certificateRepository.findAllByUserId(id);
    }
}

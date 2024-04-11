package com.example.demo.model.dto.certificate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CertificateGetDTO {
    private Long id;
    private String courseName;
    private LocalDateTime issueDate;
}

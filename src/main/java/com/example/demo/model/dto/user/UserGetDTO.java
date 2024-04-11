package com.example.demo.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGetDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime registrationDate;
}

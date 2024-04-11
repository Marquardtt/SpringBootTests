package com.example.demo.controller;

import com.example.demo.model.dto.user.UserGetDTO;
import com.example.demo.model.dto.user.UserPostDTO;
import com.example.demo.model.dto.user.UserPutDTO;
import com.example.demo.model.entity.Certificate;
import com.example.demo.model.entity.User;
import com.example.demo.service.CertificateService;
import com.example.demo.service.LessonService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping()
public class UserController {

    private UserService userService;
    private CertificateService certificateService;

    @PostMapping("/users")
    public UserGetDTO postUser(@RequestBody UserPostDTO userPostDTO){
        return userService.insertUser(userPostDTO);
    }

    @PutMapping("/users/{id}")
    public UserGetDTO putUser(@PathVariable Long id, @RequestBody UserPutDTO userPutDTO){
        return userService.putUser(id, userPutDTO);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping("users/{userId}/certificates")
    public Collection<Certificate> getAllCertificates(@PathVariable Long userId){
        return certificateService.getAll(userId);
    }
}

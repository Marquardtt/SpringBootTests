package com.example.demo.service;

import com.example.demo.model.dto.user.UserGetDTO;
import com.example.demo.model.dto.user.UserPostDTO;
import com.example.demo.model.dto.user.UserPutDTO;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserGetDTO insertUser(UserPostDTO userPostDTO){
        User user = new User();
        UserGetDTO userGetDTO = new UserGetDTO();
        modelMapper.map(userPostDTO, user);
        userRepository.save(user);
        modelMapper.map(user, userGetDTO);
        return userGetDTO;
    }

    public UserGetDTO putUser(Long id, UserPutDTO userPutDTO){
        UserGetDTO userGetDTO = new UserGetDTO();
        User user = userRepository.findById(id).get();

        modelMapper.map(userPutDTO, user);
        modelMapper.map(user, userGetDTO);
        userRepository.save(user);
        return userGetDTO;
    }

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }
}
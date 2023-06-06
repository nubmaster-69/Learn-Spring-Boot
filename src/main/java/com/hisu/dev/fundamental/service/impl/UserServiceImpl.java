package com.hisu.dev.fundamental.service.impl;

import com.hisu.dev.fundamental.exceptions.InvalidUserInfoException;
import com.hisu.dev.fundamental.exceptions.UserNotFoundException;
import com.hisu.dev.fundamental.model.User;
import com.hisu.dev.fundamental.model.response.UserResponseDTO;
import com.hisu.dev.fundamental.repository.IUserRepository;
import com.hisu.dev.fundamental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> dto = users.stream().map(UserResponseDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponseDTO> getUserById(Long id) {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent())
            return new ResponseEntity<>(new UserResponseDTO(result.get()), HttpStatus.OK);
        else
            throw new UserNotFoundException(id);
    }

    @Override
    public ResponseEntity<UserResponseDTO> addUser(User newUser) {
        newUser.setId(0); //ensure add new user

        Pattern phonePattern = Pattern.compile("^(032|033|034|035|036|037|038|039|086|096|097|098|070|079|077|076|078|089|090|093|083|084|085|081|082|088|091|094|052|056|058|092|059|099|087)[0-9]{7}$");
        
        if(!phonePattern.matcher(newUser.getPhoneNumber()).matches())
            throw new InvalidUserInfoException("Invalid phone number!");

        User user = userRepository.save(newUser);
        return new ResponseEntity<>(new UserResponseDTO(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>("Delete Successfully!", HttpStatus.OK);
        }
        else
            throw new UserNotFoundException(id);
    }

    @Override
    public ResponseEntity<UserResponseDTO> updateUser(User updateUser) {

        if(updateUser.getPhoneNumber().isEmpty() || updateUser.getUsername().isEmpty()) {
            throw new InvalidUserInfoException("Invalid params");
        }

        User user = userRepository.save(updateUser);
        return new ResponseEntity<>(new UserResponseDTO(user), HttpStatus.OK);
    }
}

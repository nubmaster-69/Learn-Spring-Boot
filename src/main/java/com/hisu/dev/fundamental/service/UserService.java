package com.hisu.dev.fundamental.service;

import com.hisu.dev.fundamental.model.User;
import com.hisu.dev.fundamental.model.response.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<UserResponseDTO>> getAll();
    ResponseEntity<UserResponseDTO> getUserById(Long id);
    ResponseEntity<UserResponseDTO> addUser(User newUser);
    ResponseEntity<String> deleteUser(Long id);
    ResponseEntity<UserResponseDTO> updateUser(User updateUser);
}
package com.hisu.dev.fundamental.rest_controller;

import com.hisu.dev.fundamental.model.User;
import com.hisu.dev.fundamental.model.response.UserResponseDTO;
import com.hisu.dev.fundamental.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all users"),
            @ApiResponse(responseCode = "404", description = "No users found")})
    @GetMapping("all")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return userService.getAll();
    }

    @Operation(summary = "Get a user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user", content = {@Content(schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Invalid user id supplied", content = @Content)})
    @GetMapping("{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New user added successfully", content = {@Content(schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Invalid user info", content = @Content)})
    @PostMapping("add")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @Operation(summary = "Update user info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User info updated successfully", content = {@Content(schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Invalid user info", content = @Content)})
    @PutMapping("update")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @Operation(summary = "Delete a user by user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully", content = {@Content(schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Invalid user id supplied", content = @Content)})
    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        return userService.deleteUser(id);
    }
}

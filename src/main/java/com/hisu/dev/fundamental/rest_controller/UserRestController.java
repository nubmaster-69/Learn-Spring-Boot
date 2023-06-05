package com.hisu.dev.fundamental.rest_controller;

import com.hisu.dev.fundamental.model.User;
import com.hisu.dev.fundamental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("{id}") // ex: /api/user/u_01
    public User getUserById(@PathVariable("id") String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        boolean result = userService.addUser(user);
        return result ? new ResponseEntity<>("Added successfully", HttpStatus.OK) : new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        boolean result = userService.updateUser(user);
        return result ? new ResponseEntity<>("updated successfully", HttpStatus.OK) : new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("delete") // ex: /api/user/delete?id=u_01
    public ResponseEntity<String> delete(@RequestParam String id) {
        boolean result = userService.deleteUser(id);
        return result ? new ResponseEntity<>("deleted successfully", HttpStatus.OK) : new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.hisu.dev.fundamental.model.response;

import com.hisu.dev.fundamental.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDTO {
    private int id;
    private String username;
    private String phoneNumber;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.phoneNumber = user.getPhoneNumber();
    }
}
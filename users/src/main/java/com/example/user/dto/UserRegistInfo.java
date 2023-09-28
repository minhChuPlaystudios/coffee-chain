package com.example.user.dto;

import com.example.user.entity.User;
import lombok.Data;

/**
 * @author minh.chu
 * @since 19/09/2023
 */
@Data
public class UserRegistInfo {
    private String username;
    private String phoneNumber;
    private String homeAddress;
    private String password;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPhoneNumber(phoneNumber);
        user.setHomeAddress(homeAddress);
        user.setPassword(password);
        return user;
    }
}

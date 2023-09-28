package com.example.user.service;

import com.example.user.entity.User;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
public interface UserService {

    User findUserByUserName(String userName);

    User saveUser(User user);

}

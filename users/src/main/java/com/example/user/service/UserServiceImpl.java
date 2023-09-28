package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;

    @Override
    public User findUserByUserName(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
}

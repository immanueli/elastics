package com.imma.elastics.service.impl;

import com.imma.elastics.entity.User;
import com.imma.elastics.repository.UserRepository;
import com.imma.elastics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
}

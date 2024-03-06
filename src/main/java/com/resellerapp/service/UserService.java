package com.resellerapp.service;

import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    UserEntity findById(Long id);
}

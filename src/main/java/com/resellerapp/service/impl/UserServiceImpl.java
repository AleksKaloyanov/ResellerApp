package com.resellerapp.service.impl;

import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.service.UserServiceModel;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);

        return modelMapper
                .map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return modelMapper.map(userRepository
                .findByUsernameAndPassword(username, password), UserServiceModel.class);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id).setUsername(username);
    }

    @Override
    public UserEntity findCurrentLoginUserEntity() {
        return userRepository
                .findById(currentUser.getId())
                .orElse(null);
    }

    @Override
    public void logout() {
        currentUser.setId(null).setUsername(null);
    }


}

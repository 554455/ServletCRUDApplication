package com.umaraliev.crud.service;

import com.umaraliev.crud.model.User;
import com.umaraliev.crud.repository.impl.UserRepositoryImpl;

public class AuthenticationService {
    private final UserRepositoryImpl userRepositoryImpl;

    public AuthenticationService(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }


    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        User user = userRepositoryImpl.getByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
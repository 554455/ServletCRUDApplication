package com.umaraliev.crud.service;

import com.umaraliev.crud.model.User;
import com.umaraliev.crud.repository.UserRepository;
import com.umaraliev.crud.repository.impl.UserRepositoryImpl;

import java.util.List;

public class UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    public User getById(Integer integer) {
        return userRepository.getById(integer);
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

}

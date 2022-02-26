package com.umaraliev.crud.repository;

import com.umaraliev.crud.model.User;

public interface UserRepository extends GenericRepository<User, Integer>{
    User getByUsername(String name);
}

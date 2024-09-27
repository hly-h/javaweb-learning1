package com.example.bookonline.dao;

import com.example.bookonline.entity.User;

public interface UserDao {
    int insertUser(User user);

    User findUser(User userDto);

    User findUserByAccount(String account);

    boolean saveUser(User user);
}

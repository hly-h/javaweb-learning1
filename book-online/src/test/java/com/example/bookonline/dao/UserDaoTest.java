package com.example.bookonline.dao;

import com.example.bookonline.dao.impl.UserDaoImpl;
import com.example.bookonline.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UserDaoTest {

    @Test
    void insertUser() {
        UserDao userDao=new UserDaoImpl();
        User user= User.builder().nickname("hly").password("root").address("江苏南京")
                .avatar("https://img1.baidu.com/it/u=542902119,1885975948&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=999")
                .account("hly").build();
        userDao.insertUser(user);
    }
}
package com.example.bookonline.service.impl;

import com.example.bookonline.dao.UserDao;
import com.example.bookonline.dao.impl.UserDaoImpl;
import com.example.bookonline.entity.User;
import com.example.bookonline.service.UserService;
import com.example.bookonline.util.Md5Util;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User signIn(String account, String password){
        User user = User.builder().account(account).password(password).build();
        return userDao.findUser(user);
    }

    @Override
    public boolean signUp(String account, String phone, String password, String nickname,String address) {
        if (userDao.findUserByAccount(account) != null) {
            return false; // 用户已存在
        }
        User user = User.builder().account(account).phone(phone).password(password).nickname(nickname).avatar("https://cbu01.alicdn.com/img/ibank/O1CN01YxfVax1WLcehKHHjl_!!2214190502772-0-cib.jpg").address(address).build();
        return userDao.insertUser(user) > 0;
    }
}


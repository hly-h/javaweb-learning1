package com.example.bookonline.service;

import com.example.bookonline.entity.User;

public interface UserService {
    User signIn(String account, String password);
    // 添加注册方法的声明
    boolean signUp(String account, String phone, String password, String nickname,String address);
}

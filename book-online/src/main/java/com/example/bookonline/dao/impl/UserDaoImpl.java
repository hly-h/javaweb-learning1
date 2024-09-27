package com.example.bookonline.dao.impl;

import com.example.bookonline.dao.UserDao;
import com.example.bookonline.entity.User;
import com.example.bookonline.util.JdbcUtil;
import com.example.bookonline.util.Md5Util;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

//    @Override
//    public int insertUser(User user) {
//        String sql = "INSERT INTO t_user(account,password,nickname,avatar,address) VALUES(?,?,?,?,?)";
//        return jdbcTemplate.update(sql, user.getAccount(), Md5Util.crypt(user.getPassword()), user.getNickname(), user.getAvatar());
//    }
    @Override
    public int insertUser(User user) {
        String sql = "INSERT INTO t_user(account, phone, password, nickname, address,avatar) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, user.getAccount(), user.getPhone(), user.getPassword(), user.getNickname(), user.getAddress(),user.getAvatar());
    }

    @Override
    public User findUser(User userDto) {
        try{
        String sql = "SELECT * FROM t_user WHERE account = ? AND password = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>
                (User.class), userDto.getAccount(), userDto.getPassword());
        }catch(DataAccessException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findUserByAccount(String account) {
        String sql = "SELECT * FROM t_user WHERE account = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), account);
        } catch (DataAccessException e) {
            return null; // 用户不存在
        }
    }
    @Override
    public boolean saveUser(User user) {
        // 实现保存用户到数据库
        // 这里假设总是返回true表示保存成功
        return true;
    }
}

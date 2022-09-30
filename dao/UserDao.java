package com.nj.dao;

import com.nj.entity.User;

/**
 * @author Li
 * @version 1.0
 * @date:2022-08-13 16:28
 */

// ?不明白设置这个的意思
public interface UserDao {
    public User login(String name, String password);

    public int regist(User user);
}

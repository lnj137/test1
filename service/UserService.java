package com.nj.service;

import com.nj.entity.User;

/**
 * @author Li
 * @version 1.0
 * @date:2022-08-13 16:33
 */


// ?????
public interface UserService {

    public User login(String name, String password);
    public int regist(User user);
}

package com.nj.service.impl;

import com.nj.dao.UserDao;
import com.nj.dao.impl.UserDaoImpl;
import com.nj.entity.User;
import com.nj.service.UserService;

/**
 * @author Li
 * @version 1.0
 * @date:2022-08-13 16:35
 */
public class UserServiceImpl implements UserService {
    //  ???
    UserDao userDao = new UserDaoImpl();
    @Override

    public User login(String name, String password) {
        return userDao.login(name,password);
    }

    @Override
    public int regist(User user) {
        return userDao.regist(user);
    }
}

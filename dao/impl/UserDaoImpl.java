package com.nj.dao.impl;

import com.nj.dao.BaseDao;
import com.nj.dao.UserDao;
import com.nj.entity.User;

/**
 * @author Li
 * @version 1.0
 * @date:2022-08-13 16:31
 */
// UserDao的实现类
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User login(String name, String password) {
        String sql="select * from user where username =? and password=?";
        User user = this.queryForInstance(User.class, sql, name, password);
        return user;
    }

    @Override
    public int regist(User user) {
        String sql="insert into user(id,username,password,realname,img) values(?,?,?,?,?)";
        return this.update(sql,user.getId(),user.getUsername(),user.getPassword(),user.getRealname(),user.getImg());
    }
}

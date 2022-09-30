package com.nj.entity;

/**
 * @author Li
 * @version 1.0
 * @date:2022-08-13 16:29
 */

// 创建一个用户实例
public class User {
    // id  username  password  realname   img
    private  Integer id;
    private  String username;
    private String password;
    private String realname;
    private String img;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public User(Integer id, String username, String password, String realname, String img) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.img = img;
    }

    public User() {
    }
}

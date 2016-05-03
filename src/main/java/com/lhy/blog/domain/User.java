package com.lhy.blog.domain;

/**
 * Created by lhy on 16/5/3.
 */
public class User {

    Integer id;

    String account;

    String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}

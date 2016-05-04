package com.lhy.blog.mapper.sql;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by lhy on 16/5/4.
 */
public class UserSqlBuilder {

    public String selectById() {
        return new SQL()
                .SELECT("*")
                .FROM("user")
                .WHERE("id = #{userId}")
                .toString();
    }

    public String insertUser() {
        return new SQL()
                .INSERT_INTO("user")
                .VALUES("account, avatar", "#{account}, #{avatar}")
                .toString();
    }

    public String updateUser() {
        return new SQL()
                .UPDATE("user")
                .SET("account = #{account}, avatar = #{avatar}")
                .WHERE("id = #{id}")
                .toString();
    }

    public String deleteUserById() {
        return new SQL()
                .DELETE_FROM("user")
                .WHERE("id = #{userId}")
                .toString();
    }
}

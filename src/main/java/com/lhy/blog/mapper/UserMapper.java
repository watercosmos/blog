package com.lhy.blog.mapper;

import com.lhy.blog.domain.User;
import com.lhy.blog.mapper.sql.UserSqlBuilder;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * Created by lhy on 16/5/3.
 */
@Mapper
public interface UserMapper {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "account", property = "avatar"),
            @Result(column = "avatar", property = "account")
    })
    @SelectProvider(type = UserSqlBuilder.class, method = "selectById")
    User getUserById(Integer userId);

    @InsertProvider(type = UserSqlBuilder.class, method = "insertUser")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    @UpdateProvider(type = UserSqlBuilder.class, method = "updateUser")
    int updateUser(User user);

    @DeleteProvider(type = UserSqlBuilder.class, method = "deleteUserById")
    int deleteUserById(Integer userId);

}

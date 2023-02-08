package com.mgt.plat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgt.plat.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * package name：com.mgt.plat.mapper
 * description：
 * user：JupSat
 * modification time：2022-12-17 15:05
 * modified content：
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User queryUserByUsername(String name);

    User queryUser(@Param("username") String username, @Param("password") String password);

    @Update("update user_info set password = #{password} where email = #{email}")
    int updUserPwd(@Param(value = "email") String email, @Param(value = "password") String password);

    @Insert("insert into user_info(username,password,email,create_time)VALUES(#{username}, #{password},#{email},#{createTime})")
    int insertUser(User user);
}
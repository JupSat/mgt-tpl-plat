package com.mgt.plat.service;

import com.mgt.plat.entity.User;
import com.mgt.plat.utils.ResultBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * package name：com.mgt.plat.service.user
 * description：
 * user：JupSat
 * modification time：2022-12-17 12:45
 * modified content：
 **/
public interface UserService {
    Integer register(User user);

    User findByUserName(String username);

    User findUser(String username, String password);

    @Update("update user_info set password = #{password} where email = #{email}")
    int  updUserPwd(String email, String password);
}

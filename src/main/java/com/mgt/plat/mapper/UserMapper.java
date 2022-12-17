package com.mgt.plat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgt.plat.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * package_name：com.mgt.plat.mapper
 * description：
 * user：JupSat
 * modification time：2022-12-17 15:05
 * modified content：
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User queryUserByUsername(String name);
}
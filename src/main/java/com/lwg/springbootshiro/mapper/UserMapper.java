package com.lwg.springbootshiro.mapper;

import com.lwg.springbootshiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能描述：
 *
 * @Author: lwg
 * @Date: 2021/1/3 13:30
 */
@Mapper
public interface UserMapper {

    void save(User user);

    User findByUsername(String username);
}

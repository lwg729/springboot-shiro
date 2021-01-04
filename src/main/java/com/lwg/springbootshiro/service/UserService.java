package com.lwg.springbootshiro.service;

import com.lwg.springbootshiro.pojo.User;

/**
 * 功能描述：
 *
 * @Author: lwg
 * @Date: 2021/1/3 13:25
 */
public interface UserService {
    void register(User user);

    User findByUsername(String username);
}

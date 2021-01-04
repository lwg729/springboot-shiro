package com.lwg.springbootshiro.service.impl;

import com.lwg.springbootshiro.mapper.UserMapper;
import com.lwg.springbootshiro.pojo.User;
import com.lwg.springbootshiro.service.UserService;
import com.lwg.springbootshiro.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述：
 *
 * @Author: lwg
 * @Date: 2021/1/3 13:26
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        //随机生成salt
        String salt = SaltUtils.getSalt(8);
        //将salt保存到数据库
        user.setSalt(salt);

        //明文密码进行md5+salt+hash散列
        Md5Hash md5Hash=new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());

        userMapper.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }
}

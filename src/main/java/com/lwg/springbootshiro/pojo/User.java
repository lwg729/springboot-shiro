package com.lwg.springbootshiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述：
 *
 * @Author: lwg
 * @Date: 2021/1/3 13:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private String salt;
}

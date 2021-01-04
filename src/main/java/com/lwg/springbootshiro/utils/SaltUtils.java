package com.lwg.springbootshiro.utils;

import java.util.Random;

/**
 * 功能描述：
 *
 * @Author: lwg
 * @Date: 2021/1/3 13:46
 */
public class SaltUtils {

    //生成salt的静态方法
    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*()".toCharArray();
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < n; i++) {
            char aChar=chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }

   /* public static void main(String[] args) {
        System.out.println(getSalt(15));
    }*/
}

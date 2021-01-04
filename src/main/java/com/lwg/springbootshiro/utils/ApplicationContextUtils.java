package com.lwg.springbootshiro.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 功能描述：帮助service注入realm中  因为先认证后查询
 * 最后会展示一个空的user对象  所用交给工厂一起管理
 *
 * @Author: lwg
 * @Date: 2021/1/3 22:04
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    //根据bean名字获取工厂中指定bean对象
    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
}

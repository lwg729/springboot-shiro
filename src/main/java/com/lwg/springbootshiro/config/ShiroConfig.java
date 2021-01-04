package com.lwg.springbootshiro.config;

import com.lwg.springbootshiro.shiro.realms.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * 功能描述：用来整合shiro框架相关的配置类
 *
 * @Author: lwg
 * @Date: 2021/1/3 11:42
 */

@Configuration
public class ShiroConfig {

    //1.创建shiroFilter  负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //给过滤器设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统受限资源
        //配置系统公共资源
        HashMap<String, String> map = new HashMap<>();
        map.put("/user/login", "anon");
        map.put("/user/register", "anon");
        map.put("/register.jsp", "anon");
        map.put("/**", "authc");   //authc请求这个资源需要认证和授权

        //默认登录页面
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //3.创建自定义Realm
    @Bean
    public Realm getRealm() {
        CustomerRealm customerRealm = new CustomerRealm();
        //修改凭证检验匹配器
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(matcher);
        return customerRealm;
    }

}

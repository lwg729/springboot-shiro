package com.lwg.springbootshiro.shiro.realms;

import com.lwg.springbootshiro.pojo.User;
import com.lwg.springbootshiro.service.impl.UserServiceImpl;
import com.lwg.springbootshiro.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ObjectUtils;

/**
 * 功能描述：自定义realm
 *
 * @Author: lwg
 * @Date: 2021/1/3 11:47
 */
public class CustomerRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        UserServiceImpl userService = (UserServiceImpl) ApplicationContextUtils.getBean("userService");
        User user = userService.findByUsername(principal);
        //System.out.println(userService);
        if (!ObjectUtils.isEmpty(user)) {
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),
                    this.getName());
        }
        return null;
    }
}

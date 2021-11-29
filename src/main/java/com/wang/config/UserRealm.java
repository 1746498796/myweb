package com.wang.config;

import com.wang.pojo.Login;
import com.wang.serviceImpl.LoginServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    LoginServiceImpl userService;

    //认证方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("认证方法=>doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        Login currentUser = (Login) subject.getPrincipal();//获取user对象
        info.addStringPermission(currentUser.getPerms());//添加授权认证


        return info;
    }
    //授权方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("授权方法=>doGetAuthenticationInfo");



        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        Login user = userService.queryByUserName(userToken.getUsername());
        if (user==null){
            return  null;
        }
        //   可以将user进行传递，在通过subject再授权的方法中获取
        return new SimpleAuthenticationInfo(user,user.getPassWord(),"");
    }
}

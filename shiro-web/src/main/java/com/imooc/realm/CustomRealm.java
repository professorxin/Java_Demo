package com.imooc.realm;

import com.imooc.dao.UserDao;
import com.imooc.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //判断是否有角色权限
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles = getRoleByName(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }


    private Set<String> getRoleByName(String name) {
        Set<String> set = userService.getRoles(name);
        return set;
    }


    //判断是否有登陆权限
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = (String) authenticationToken.getPrincipal();
        String password = getPassword(name);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, password, "abc");
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(name));
        return simpleAuthenticationInfo;
    }

    private String getPassword(String name) {
        String password=userService.getPasswordByName(name);
        return password;
    }

}
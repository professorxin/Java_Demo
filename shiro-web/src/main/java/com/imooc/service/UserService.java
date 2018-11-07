package com.imooc.service;

import com.imooc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Set<String> getRoles(String name) {
        Set<String> set=userDao.getRoles(name);
        return set;
    }

    public String getPasswordByName(String name) {
        String password=userDao.getPasswordByName(name);
        return password;
    }
}

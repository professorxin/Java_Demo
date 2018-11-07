package com.imooc.dao;

import java.util.ArrayList;
import java.util.Set;

public interface UserDao {

    public String getPasswordByName(String name);

    public Set<String> getRoles(String name);
}

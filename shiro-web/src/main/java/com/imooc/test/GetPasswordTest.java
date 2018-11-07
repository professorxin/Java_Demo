package com.imooc.test;

import com.imooc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class GetPasswordTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetPassword(){
        String password=userService.getPasswordByName("asdfgh");
        System.out.println(password);
    }

}

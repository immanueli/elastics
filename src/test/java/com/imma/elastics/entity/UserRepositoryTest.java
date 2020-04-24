package com.imma.elastics.entity;


import com.imma.elastics.ElasticsApplicationTests;
import com.imma.elastics.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRepositoryTest extends ElasticsApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testFindOne(){
        User user = userService.getUserById(1L);
        Assert.assertEquals("waliwali",user.getName());
    }
}

package me.freelee.mybatisdruid;

import me.freelee.mybatisdruid.model.User;
import me.freelee.mybatisdruid.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisDruidApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserService userService;

    @Test
    public void testInsertUser(){
        User user=new User("ljp","ZheJiang");
        userService.insertUser(user);
    }

}

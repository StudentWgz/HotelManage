package com.atguigu.admin;

import com.atguigu.admin.po.User;
import com.atguigu.admin.service2.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class Spring03BootApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_customer", Long.class);
        log.info("记录总数：{}",aLong);
        log.info("数据源类型{}",dataSource.getClass());
    }

    @Test
    void mapperTest(){
        User user1 = userService.getUserByName("zhangsan");
        List<User> user =userService.list();
        System.out.println("user1:"+user1);
        for(User user2 : user){
            System.out.println(user2);
        }
    }
    @Test
    void javaTest(){
        String a="123";
        String b="aaa";
        String c=a+b;
        log.info("c={}",c);
    }

}

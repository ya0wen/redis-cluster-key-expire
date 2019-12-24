package com.example.demo;

import com.example.demo.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    ApplicationContext applicationContext;

    @Test
    public void test(){
//        redisUtil.set("test","test");
//        Object test = redisUtil.get("test");
//
//        System.out.println(test+"");
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.set("test1","test2",2);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

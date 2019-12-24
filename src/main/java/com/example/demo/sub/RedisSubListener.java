package com.example.demo.sub;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisSubListener implements MessageListener {

//    @Autowired
//    RedisUtil redisUtil;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("onPMessage pattern " + bytes + " " + " " + message);
        String channel = new String(message.getChannel());
    }
}

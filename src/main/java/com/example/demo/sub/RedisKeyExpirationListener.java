package com.example.demo.sub;

import com.example.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;


public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    @Autowired
    RedisUtil redisUtil;

//    @Autowired
//    LoginUserStatisticsMapper loginUserStatisticsMapper;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,message.toString()可以获取失效的key
        String mesg = message.toString();
        System.out.println(mesg);
    }
}

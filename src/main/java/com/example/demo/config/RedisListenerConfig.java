package com.example.demo.config;

import com.example.demo.sub.RedisSubListener;
import com.example.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisListenerConfig {

    /**
     * Type safe representation of application.properties
     */
    @Autowired
    ClusterConfigurationProperties clusterProperties;

    public  RedisConnectionFactory connectionFactory() {
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(clusterProperties.getNodes());
        return new LettuceConnectionFactory(redisClusterConfiguration);
    }

//    @Bean("messageListener")
    public MessageListener messageListener(){
       return new RedisSubListener();
    }

//    @Bean
//    public RedisMessageListenerContainer customizeRedisListenerContainer(
//            RedisConnectionFactory connectionFactory, MessageListener messageListener) {
//        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//        redisMessageListenerContainer.setConnectionFactory(connectionFactory);
//        redisMessageListenerContainer.addMessageListener(messageListener,new PatternTopic("__keyspace@0__:*"));
//        return redisMessageListenerContainer;
//    }

//    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean("redisUtil")
    public RedisUtil redisUtil(){
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setRedisTemplate(redisTemplate());
        return redisUtil;
    }

}

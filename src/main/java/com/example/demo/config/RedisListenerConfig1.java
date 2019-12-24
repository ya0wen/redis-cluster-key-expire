package com.example.demo.config;

import com.example.demo.sub.RedisKeyExpirationListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisListenerConfig1 {

    @Value("${redis.host1}")
    private String host1;

    @Value("${redis.host2}")
    private String host2;

    @Value("${redis.host3}")
    private String host3;

    @Value("${redis.host4}")
    private String host4;

    @Value("${redis.host5}")
    private String host5;

    @Value("${redis.host6}")
    private String host6;

    @Value("${redis.port1}")
    private int port1;

    @Value("${redis.port2}")
    private int port2;

    @Value("${redis.port3}")
    private int port3;

    @Value("${redis.port4}")
    private int port4;

    @Value("${redis.port5}")
    private int port5;

    @Value("${redis.port6}")
    private int port6;

    @Bean
    JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxWaitMillis(1000);
        return jedisPoolConfig;
    }

    // redis-cluster不支持key过期监听，建立多个连接，对每个redis节点进行监听
    @Bean
    RedisMessageListenerContainer redisContainer1() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host1);
        jedisConnectionFactory.setPort(port1);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        jedisConnectionFactory.afterPropertiesSet();
        container.setConnectionFactory(jedisConnectionFactory);
        return container;
    }

    @Bean
    RedisMessageListenerContainer redisContainer2() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host2);
        jedisConnectionFactory.setPort(port2);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        jedisConnectionFactory.afterPropertiesSet();
        container.setConnectionFactory(jedisConnectionFactory);
        return container;
    }

    @Bean
    RedisMessageListenerContainer redisContainer3() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host3);
        jedisConnectionFactory.setPort(port3);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        jedisConnectionFactory.afterPropertiesSet();
        container.setConnectionFactory(jedisConnectionFactory);
        return container;
    }

    @Bean
    RedisMessageListenerContainer redisContainer4() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host4);
        jedisConnectionFactory.setPort(port4);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        jedisConnectionFactory.afterPropertiesSet();
        container.setConnectionFactory(jedisConnectionFactory);
        return container;
    }

    @Bean
    RedisMessageListenerContainer redisContainer5() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host5);
        jedisConnectionFactory.setPort(port5);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        jedisConnectionFactory.afterPropertiesSet();
        container.setConnectionFactory(jedisConnectionFactory);
        return container;
    }

    @Bean
    RedisMessageListenerContainer redisContainer6() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host6);
        jedisConnectionFactory.setPort(port6);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        jedisConnectionFactory.afterPropertiesSet();
        container.setConnectionFactory(jedisConnectionFactory);
        return container;
    }

    @Bean
    RedisKeyExpirationListener redisKeyExpirationListener1() {
        return new RedisKeyExpirationListener(redisContainer1());
    }

    @Bean
    RedisKeyExpirationListener redisKeyExpirationListener2() {
        return new RedisKeyExpirationListener(redisContainer2());
    }

    @Bean
    RedisKeyExpirationListener redisKeyExpirationListener3() {
        return new RedisKeyExpirationListener(redisContainer3());
    }

    @Bean
    RedisKeyExpirationListener redisKeyExpirationListener4() {
        return new RedisKeyExpirationListener(redisContainer4());
    }

    @Bean
    RedisKeyExpirationListener redisKeyExpirationListener5() {
        return new RedisKeyExpirationListener(redisContainer5());
    }

    @Bean
    RedisKeyExpirationListener redisKeyExpirationListener6() {
        return new RedisKeyExpirationListener(redisContainer6());
    }

}

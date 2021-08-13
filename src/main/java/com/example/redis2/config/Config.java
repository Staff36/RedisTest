package com.example.redis2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ComponentScan("com.example.redis2")
public class Config {

    @Bean
    public JedisConnectionFactory connectionFactory(){
        return new JedisConnectionFactory();

    }

    @Bean
    public StringRedisTemplate redisTemplate(){
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }
}

package com.example.redis2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class StudentsService {

    @Autowired
    private StringRedisTemplate template;

    public void put(String token, Long time) {
        template.opsForHash().put(token, "", "val");
        template.opsForValue().set(token, "empty", Duration.ofSeconds(time));
    }

    public boolean hasKey(String id) {
        return findById(id) != null;
    }

    public String findById(String id) {
        return template.opsForValue().get(id);
    }
}

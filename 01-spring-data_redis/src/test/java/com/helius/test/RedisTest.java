package com.helius.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Author jcf
 * @Create 2020-01-01-15:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springContext-redis.xml")
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSave() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        //获取操作简单字符串类型数据的数据句柄
        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("name3","helius");
        valueOperations.set("name4","helius2",10, TimeUnit.SECONDS);

    }
}

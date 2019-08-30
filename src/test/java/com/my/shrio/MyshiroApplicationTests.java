package com.my.shrio;

import com.my.shrio.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyshiroApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 测试redis连接
     */
    @Test
    public void testRedis(){
        String  s = "abcf";
        byte[] key = s.getBytes();
        String s1 = "13132";
        byte[] value = s1.getBytes();

        redisUtil.set(key,value);
    }


}

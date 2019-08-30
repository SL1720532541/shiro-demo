package com.my.shrio.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Set;

@Component
public class RedisUtil {

    @Autowired
    private JedisPool jedisPool;

    private Jedis getResource() {
        return jedisPool.getResource();
    }

    public void set(byte[] key, byte[] value) {
        Jedis jedis = getResource();
        try {
            jedis.set(key, value);
        } finally{
            jedis.close();
        }
    }

    public void expire(byte[] key, int time) {
        Jedis jedis = getResource();
        try {
            jedis.expire(key, time);
        } finally{
            jedis.close();
        }
    }

    public byte[] get(byte[] key) {
        Jedis jedis = getResource();
        try {
            return jedis.get(key);
        } finally{
            jedis.close();
        }
    }

    public void del(byte[] key) {
        Jedis jedis = getResource();
        try {
            jedis.del(key);
        } finally{
            jedis.close();
        }
    }

    public Set<byte[]> keys(String shiroShiroPrefix) {
        Jedis jedis = getResource();
        try {
            return jedis.keys((shiroShiroPrefix + "*").getBytes());
        } finally{
            jedis.close();
        }
    }
}

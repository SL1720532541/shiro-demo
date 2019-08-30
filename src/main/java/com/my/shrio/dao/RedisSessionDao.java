package com.my.shrio.dao;

import com.my.shrio.util.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RedisSessionDao extends AbstractSessionDAO {

    @Autowired
    RedisUtil redisUtil;

    private static final String SHIRO_SHIRO_PREFIX = "session";

    /**
     * 使用sessionId + 前缀的二进制形式作为key
     * @param key
     * @return
     */
    private byte[] getKey(String key) {
        return (SHIRO_SHIRO_PREFIX + key).getBytes();
    }

    private void saveSession(Session session){
        //System.out.println("执行保存session");
        byte[] key = getKey(session.getId().toString());
        // 序列化为byte数组
        byte[] value = SerializationUtils.serialize(session);
        redisUtil.set(key, value);
        redisUtil.expire(key, 600);//10分钟
    }

    @Override
    protected Serializable doCreate(Session session) {
        System.out.println("新增session = [" + session + "]");
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        byte[] key = getKey( sessionId.toString());
        byte[] value = redisUtil.get(key);
        return (Session) SerializationUtils.deserialize(value);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        System.out.println("更新session");
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if(session == null || session.getId() == null){
            return;
        }
        byte[] key = getKey(session.getId().toString());
        redisUtil.del(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<byte[]> keys = redisUtil.keys(SHIRO_SHIRO_PREFIX);
        if(keys == null || keys.size() == 0){
            return null;
        }
        Set<Session> sessions = new HashSet<>();
        for (byte[] key:keys) {
            Session session = (Session)SerializationUtils.deserialize(redisUtil.get(key));
            sessions.add(session);
        }
        return sessions;
    }
}

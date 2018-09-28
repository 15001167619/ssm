package com.whs.ssm.service.impl;

import com.whs.ssm.config.PassportRedis;
import com.whs.ssm.service.CoreRedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @author 武海升
 * @date 2018/7/10 18:40
 */
@Service("redisService")
public class CoreRedisServiceImpl implements CoreRedisService {

    @Override
    public boolean keyExists(String key) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public void addToRedis(String key, String value) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    @Override
    public void addToRedis(String key, String value, int expire) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set(key, value);
            jedis.expire(key, expire);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }

        }
    }

    @Override
    public String getRedisValueByKey(String key) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String value = jedis.get(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return null;
    }

    @Override
    public boolean deleteRedisValueByKey(String key) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return true;
    }




    @Override
    public String hget(String key, String field) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        String result = null;
        try {
            jedis = pool.getResource();
            result = jedis.hget(key ,field);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hset(String key, String field, String value) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = pool.getResource();
            result =jedis.hset(key,field,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = pool.getResource();
            result = jedis.expire(key,seconds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public void addListToRedis(String key, String value) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.lpush(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }

    }

    @Override
    public List<String> getListFromRedis(String key, Long min, Long max) {
        JedisPool pool = PassportRedis.getPool();
        Jedis jedis = null;
        List<String> lrange = null;
        try {
            jedis = pool.getResource();
            lrange = jedis.lrange(key, min, max);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        return lrange;
        }
    }


}

package com.yur.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


@RestController
@RequestMapping(value = "jedis")
public class JedisTest {

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis(){
        return jedisPool.getResource();
    }

    @ResponseBody
    @RequestMapping("/key/{key}")
    public Object getKey(@PathVariable String key){
        return jedis().get(key);
    }

    /*private final static String ip = "47.98.217.141";
    private final static int port = 6379;
    private final static int timeout = 3000;
    private final static String require = "Redis2ly";

    private static JedisPool jedisPool = null;
    private static JedisPoolConfig jedisPoolConfig = null;

    public static void getJedisPool(){
        if(jedisPool == null){
            jedisPoolConfig = new JedisPoolConfig();
            jedisPool = new JedisPool(jedisPoolConfig, ip, port, 3000, require);
        }
    }

    public static void main(String[] args) {
        if(jedisPool == null){
            getJedisPool();
        }
        String value = jedisPool.getResource().get("yur");
        System.out.println(value);
    }*/

}

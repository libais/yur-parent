package com.yur.springboot;

import com.yur.util.crypto.Crypto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.yur")
@PropertySource(value={"classpath:redis.properties"} , ignoreResourceNotFound = true )
public class RedisApplication extends SpringBootServletInitializer {

    @Value("${redis.ip}")
    private String ip;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.require}")
    private String require;

    @Bean
    public JedisPoolConfig jedisPoolConifg(){
        JedisPoolConfig jedisPoolConifg = new JedisPoolConfig();
        return jedisPoolConifg;
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConifg){
        JedisPool jedisPool = new JedisPool(jedisPoolConifg,
                ip, port, 3000, Crypto.decrypt(require, Crypto.KEY));
        return jedisPool;
    }

}

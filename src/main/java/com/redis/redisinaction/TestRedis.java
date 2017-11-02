package com.redis.redisinaction;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by Administrator on 2017/11/2.
 */
public class TestRedis {
    public static void main(String[] args) {
        Jedis conn = new Jedis("192.168.136.128",6379);
        conn.select(0);
        Set<String> keys = conn.keys("*");
        System.out.println(keys);
    }
}

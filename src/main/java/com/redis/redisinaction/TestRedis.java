package com.redis.redisinaction;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by Administrator on 2017/11/2.
 */
public class TestRedis {
    public static void main(String[] args) {
        Jedis conn = new Jedis(Constants.REDIS_URL,Constants.REDIS_PORT);
        conn.select(15);
        Set<String> keys = conn.keys("*");
        System.out.println(keys);
        Long num = conn.zadd("article222:score", 23.13d, "article111");
        System.out.println(num);

        conn.set("hahah:asdf","hehehe");
        Long num2 = conn.zadd("article222:score", 45.67d, "article222");
        System.out.println(conn.zcard("article222:score"));
        Set<String> zrange = conn.zrange("article222:score", 0, -1);
        System.out.println(zrange);

        conn.zadd("countryRange",222,"zhongguo");
        conn.zadd("countryRange",333,"meiguo");
        Set<String> zrange2 = conn.zrange("countryRange", 0, -1);
        System.out.println(zrange2);
    }
}

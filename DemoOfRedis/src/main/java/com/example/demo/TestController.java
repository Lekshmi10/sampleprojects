package com.example.demo;

import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/getRedis")
public class TestController {

    @GetMapping("/stringValue")
    public String stringValue()  {
        Jedis jedis = new Jedis("localhost", 6379);
        String response = jedis.ping();
        System.out.println("Redis server responded: " + response);
        //setting the value here
        jedis.set("mykey","Hello! Am from Redis");
        //getting the value
        String value = jedis.get("mykey");
        System.out.println("Value of myKey: " + value);
        jedis.close();
        return value;
    }
    @GetMapping("/listValue")
    public List<String> listValue()  {
        Jedis jedis = new Jedis("localhost", 6379);
       jedis.rpush("myList","first","second","third","fourth","fifth");
       //getting list values
        List<String> myListValue=jedis.lrange("myList",0,-1);
        jedis.close();
        return myListValue;
    }

    @GetMapping("/setValue")
    public Set<String> setValue()  {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.sadd("mySet","first","second","third","fourth","fifth");
        //getting list values
        Set<String> mysetValue=jedis.smembers("mySet");
        jedis.close();
        return mysetValue;
    }
    @GetMapping("/mapValue")
    public Map<String, String> mapValue()  {
        Jedis jedis=new Jedis("localhost",6379);
       jedis.hset("myHash","field1","value1");
       jedis.hset("myHash","field2","value2");
       jedis.hset("myHash","field3","value3");
       //fetching values
        Map<String, String> myValues=jedis.hgetAll("myHash");
        jedis.close();
        return myValues;
    }
}

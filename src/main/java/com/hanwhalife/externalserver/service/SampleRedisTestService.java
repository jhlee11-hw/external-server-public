//package com.hanwhalife.externalserver.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//@Slf4j
//@Service
//public class SampleRedisTestService {
//
//    private final StringRedisTemplate redisTemplate;
//
//    public SampleRedisTestService(StringRedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Cacheable(value="sampleData")
//    public List<String> getSimpleData(){
//        log.info("start getSampleData");
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//
//        return list;
//    }
//
//    @CacheEvict(value="sampleData" , allEntries = true)
//    public void simpleDataEvict(){
//        log.info("cache evict");
//    }
//
//    public List<String> getAll() {
//        Set<String> sampleKeys = redisTemplate.keys("sample*");
//
//        List<String> stringList = new ArrayList<>();
//        if(sampleKeys != null) {
//            for(String key: sampleKeys) {
//                stringList.add(redisTemplate.opsForValue().get(key));
//            }
//        }
//
//        return stringList;
//    }
//}

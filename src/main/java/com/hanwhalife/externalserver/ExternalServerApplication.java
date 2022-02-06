package com.hanwhalife.externalserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@EnableCaching
@SpringBootApplication (
        exclude = {
                //RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class,
                MongoAutoConfiguration.class, MongoDataAutoConfiguration.class
        }
)
public class ExternalServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalServerApplication.class, args);
    }

}

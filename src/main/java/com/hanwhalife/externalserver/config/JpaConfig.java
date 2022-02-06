package com.hanwhalife.externalserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JpaConfig {

    private final EntityManagerFactoryBuilder entityManagerFactoryBuilder;
    private final DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.hanwhalife.externalserver.**")
                .build();
    }
}
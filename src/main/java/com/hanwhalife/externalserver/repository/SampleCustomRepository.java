package com.hanwhalife.externalserver.repository;

import com.hanwhalife.externalserver.domain.entity.QSample;
import com.hanwhalife.externalserver.domain.entity.Sample;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SampleCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public SampleCustomRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Sample> findSampleByName(String name) {
        QSample s = QSample.sample;
        JPAQuery<Sample> query = jpaQueryFactory.selectFrom(s);

        if(name != null) {
            query.where(s.name.eq(name));
        }

        return query.fetch();
    }
}

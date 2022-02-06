package com.hanwhalife.externalserver.repository;

import com.hanwhalife.externalserver.domain.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
}

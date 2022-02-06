package com.hanwhalife.externalserver.service;

import com.hanwhalife.externalserver.domain.entity.Sample;
import com.hanwhalife.externalserver.repository.SampleCustomRepository;
import com.hanwhalife.externalserver.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;
    private final SampleCustomRepository sampleCustomRepository;

    @Transactional
    public void createSample(Sample s) {
        sampleRepository.save(s);
    }

    @Transactional(readOnly = true)
    public List<Sample> getSampleList() {
        return sampleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Sample> getSample(Long sampleId) {
        return sampleRepository.findById(sampleId);
    }

    @Transactional(readOnly = true)
    public List<Sample> getSampleListByName(String name) {
        return sampleCustomRepository.findSampleByName(name);
    }
}

package com.hanwhalife.externalserver.service;

import com.hanwhalife.externalserver.domain.entity.Sample;
import com.hanwhalife.externalserver.repository.SampleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class SampleServiceTest {
    Logger log = LoggerFactory.getLogger(SampleServiceTest.class);

    @InjectMocks
    private SampleService sampleService;

    @Mock
    private SampleRepository sampleRepository;

    @DisplayName("샘플 리스트 조회 서비스 테스트")
    @Test
    public void getSampleListTest() {
        // given
        List<Sample> sampleList = new ArrayList<>();
        sampleList.add(new Sample(1L, "aaa", "aaa@mail.com"));
        sampleList.add(new Sample(2L, "bbb", "bbb@mail.com"));
        sampleList.add(new Sample(3L, "ccc", "ccc@mail.com"));
        doReturn(sampleList).when(sampleRepository).findAll();

        // when
        List<Sample> sampleListResult = sampleService.getSampleList();
        log.info("[sampleListResult size] " + sampleListResult.size());

        // then
        assertTrue(sampleListResult.size() > 0);
    }
}
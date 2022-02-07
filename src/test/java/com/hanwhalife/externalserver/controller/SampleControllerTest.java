package com.hanwhalife.externalserver.controller;

import com.google.gson.*;
import com.hanwhalife.externalserver.domain.dto.SampleDto;
import com.hanwhalife.externalserver.domain.entity.Sample;
import com.hanwhalife.externalserver.service.SampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class SampleControllerTest{

    @InjectMocks
    private SampleController sampleController;

    @Mock
    private SampleService sampleService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(sampleController).build();
    }

    @DisplayName("샘플 생성")
    @Test
    void createSample() throws Exception {
        //given
        final Sample sample = new Sample();
        sample.setEmail("george@mail.com");
        sample.setName("george");
        when(sampleService.createSample(sample)).thenReturn(sample);
        doReturn(sample).when(sampleService).createSample(sample);

        //when
        final ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/samples")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                new Gson().toJson(
                                        new SampleDto()
                                                .setEmail("george@mail.com")
                                                .setName("george")
                                )
                        )
        );

        //then
        resultActions.andExpect(status().isOk());
    }
}

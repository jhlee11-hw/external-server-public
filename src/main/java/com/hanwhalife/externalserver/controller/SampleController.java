package com.hanwhalife.externalserver.controller;

import com.hanwhalife.externalserver.domain.ApiResponse;
import com.hanwhalife.externalserver.domain.dto.SampleDto;
import com.hanwhalife.externalserver.domain.entity.Sample;
import com.hanwhalife.externalserver.exception.CustomException;
import com.hanwhalife.externalserver.service.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/samples")
@Tag(name = "Sample apis")
@Slf4j
public class SampleController {
    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @Operation(description = "샘플생성")
    @PostMapping
    public ResponseEntity<ApiResponse> addSample (@RequestBody SampleDto sampleDto) {
        log.info("[addSample]" + sampleDto.getEmail() + "," + sampleDto.getName());

        Sample sample = new Sample();
        sample.setName(sampleDto.getName());
        sample.setEmail(sampleDto.getEmail());
        sampleService.createSample(sample);

        return ResponseEntity.ok(ApiResponse.success("ok", 1));
    }

    @Operation(description = "샘플조회")
    @GetMapping(value ="/{id}")
    public ResponseEntity<ApiResponse> getSample(@PathVariable String id) throws Exception {
        log.info("[getSample]" + id);

        Sample sample = sampleService.getSample(Long.valueOf(id))
                .orElseThrow(() -> new CustomException("can't find sample"));

        SampleDto dto = new SampleDto();
        dto.setId(sample.getId());
        dto.setEmail(sample.getEmail());
        dto.setName(sample.getName());

        return ResponseEntity.ok(ApiResponse.success("ok", dto));
    }

    @Operation(description = "샘플복수조회")
    @GetMapping
    public ResponseEntity<ApiResponse> getSampleList(@RequestParam @Nullable String name) throws Exception {
        log.info("[getSampleList] param=>{}", name);

        List<Sample> sampleList = sampleService.getSampleListByName(name);
        if(sampleList.isEmpty()) {
            throw new CustomException("can't find sampleList");
        }

        return ResponseEntity.ok(ApiResponse.success("ok", sampleList));
    }
}
package com.hanwhalife.externalserver.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SampleDto {
    @Schema(description = "아이디", example = "33")
    private long id;
    @Schema(description = "샘플이름", example = "철수")
    private String name;
    @Schema(description = "샘플이메일", example = "sample@sample.com")
    private String email;
}

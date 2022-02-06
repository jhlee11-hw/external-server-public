package com.hanwhalife.externalserver.domain;

import com.hanwhalife.externalserver.domain.enums.StatusEnum;
import lombok.Data;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotNull;

@Data
public class ApiResponse {
    private int code;
    private String message;
    private Object data;

    public ApiResponse(@Nullable int code, @Nullable String message, @Nullable Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @NotNull
    synchronized public static ApiResponse error(@Nullable int code, @Nullable String message) {
        return new ApiResponse(code, message, null);
    }

    @NotNull
    synchronized public static ApiResponse success(@Nullable String message, @Nullable Object data) {
        return new ApiResponse(StatusEnum.OK.getStatusCode(), message, data);
    }
}

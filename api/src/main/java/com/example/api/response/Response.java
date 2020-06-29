package com.example.api.response;

import com.example.api.response.result.Result;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonProperty
    private Result result;

    public Response(HttpStatus httpStatus, String message) {
        this.errorCode = String.valueOf(httpStatus.value());
        this.message = message;
    }

    public Response(Result result) {
        this.result = result;
    }
}

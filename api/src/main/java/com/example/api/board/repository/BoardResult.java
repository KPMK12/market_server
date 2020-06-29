package com.example.api.board.repository;

import com.example.api.response.result.Result;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("result")
public class BoardResult implements Result {

    @JsonProperty
    private String title;
    @JsonProperty
    private String content;

    public BoardResult(BoardDo boardDo) {
        this.title = boardDo.getTitle();
        this.content = boardDo.getContent();
    }
}

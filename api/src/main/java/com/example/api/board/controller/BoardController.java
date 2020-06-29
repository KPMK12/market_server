package com.example.api.board.controller;

import com.example.api.board.repository.BoardDo;
import com.example.api.board.repository.BoardResult;
import com.example.api.board.repository.BoardService;
import com.example.api.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequiredArgsConstructor
public class BoardController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @GetMapping(path = "api/v1/board/{boardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getBoard(@PathVariable Long boardId) {

        BoardDo boardDo = boardService.getBoard(boardId);
        if (boardDo == null) {
            return ResponseEntity.notFound().build();
        }
        Response r = new Response(new BoardResult(boardDo));
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @PostMapping("api/v1/board")
    public ResponseEntity<Response> postBoard(@RequestBody BoardDo board) {
        LOGGER.debug(board.toString());
        BoardDo boardDo = boardService.save(board);
        if (boardDo == null) {
            return ResponseEntity.notFound().build();
        }
        Response r = new Response(new BoardResult(boardDo));
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
}
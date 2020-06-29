package com.example.api.board.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;


    public Page<BoardDo> list(int page, int size) {

        return boardDao.findAll(PageRequest.of(page, size));

    }

    public BoardDo save(BoardDo boardDo) {
        try {
            return this.boardDao.save(boardDo);

        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public BoardDo getBoard(Long board_id)  {
        try {
            return boardDao.getOne(board_id);

        } catch (EntityNotFoundException e) {

            return null;
        }
    }
}
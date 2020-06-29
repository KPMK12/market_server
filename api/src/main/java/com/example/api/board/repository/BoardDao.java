package com.example.api.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDao extends JpaRepository<BoardDo, Long> {


}
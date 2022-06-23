package com.cwg.test.service;

import com.cwg.test.dto.BoardDto;

import java.util.List;

public interface BoardService {

    void createBoard(BoardDto boardDto);

    List<BoardDto> boardList(String id);

}

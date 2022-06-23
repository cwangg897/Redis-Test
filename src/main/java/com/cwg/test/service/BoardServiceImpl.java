package com.cwg.test.service;


import com.cwg.test.dto.BoardDto;
import com.cwg.test.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public void createBoard(BoardDto boardDto) {
        boardMapper.createBoard(boardDto);
    }

    @Override
    @Cacheable(cacheNames = "board", key = "#id")
    public List<BoardDto> boardList(String id) {
        return boardMapper.findAllById(id);
    }
}

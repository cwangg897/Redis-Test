package com.cwg.test.controller;


import com.cwg.test.dto.BoardDto;
import com.cwg.test.dto.UserDto;
import com.cwg.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/books/{id}")
    public List<BoardDto> boardList(@PathVariable String id){
        return boardService.boardList(id);
    }

    @PostMapping("/books")
    public void createBoard(@RequestBody BoardDto boardDto){
        boardService.createBoard(boardDto);
    }
}

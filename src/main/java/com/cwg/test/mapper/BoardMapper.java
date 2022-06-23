package com.cwg.test.mapper;

import com.cwg.test.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void createBoard(BoardDto boardDto);

    List<BoardDto> findAllById(String id);
}

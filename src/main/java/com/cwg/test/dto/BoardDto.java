package com.cwg.test.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardDto {

    private String title;

    private String writer;

    @Builder
    public BoardDto(String title, String writer){
        this.title = title;
        this.writer = writer;
    }


}

package com.cwg.test.dto;


import com.cwg.test.util.UserLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserDto {

    private String id;
    private String password;
    private UserLevel level;

    @Builder
    public UserDto(String id, String password, UserLevel level){
        this.id = id;
        this.password = password;
        this.level = level;
    }

}

package com.cwg.test.mapper;


import com.cwg.test.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    void insertUser(UserDto userDto);

    Optional<UserDto> findById(String id, String password);

    boolean isExistUser(String id);


    List<UserDto> findAll();
}

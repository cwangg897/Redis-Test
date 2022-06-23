package com.cwg.test.service;

import com.cwg.test.dto.UserDto;

import java.util.List;

public interface UserService {

    void signup(UserDto userDto);

    void login(String id, String password);

    List<UserDto> findAll();

}

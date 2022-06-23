package com.cwg.test.service;

import com.cwg.test.dto.UserDto;

public interface UserService {

    void signup(UserDto userDto);

    void login(String id, String password);
}

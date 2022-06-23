package com.cwg.test.service;

import com.cwg.test.dto.UserDto;
import com.cwg.test.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    @Override
    public void signup(UserDto userDto) {
        if(userMapper.isExistUser(userDto.getId())){
            throw new RuntimeException("이미 존재하는 회원입니다.");
        }
        userMapper.insertUser(userDto);
    }

    @Override
    public void login(String id, String password) {
        Optional<UserDto> findUser = userMapper.findById(id, password);
        if(!findUser.isPresent()){
            throw new RuntimeException("아이디가 존재하지않습니다");
        }
        if(!findUser.get().getPassword().equals(password)){
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }
        // 그런데 실제에서는 비밀번호가 유효하지않거나 아이디가 유효하지않은지 정확하게안알려준다. 그래서 비번만체크하기

    }
}

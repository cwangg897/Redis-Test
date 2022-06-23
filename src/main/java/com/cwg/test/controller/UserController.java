package com.cwg.test.controller;

import com.cwg.test.dto.UserDto;
import com.cwg.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final ResponseEntity REQUEST_OK = new ResponseEntity(HttpStatus.OK);
    private final ResponseEntity REQUEST_CONFLICT = new ResponseEntity(HttpStatus.BAD_REQUEST);

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody UserDto userDto){
        userService.signup(userDto);
        return REQUEST_OK;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(HttpSession session, @RequestBody UserDto userDto){
        String id = userDto.getId();
        String password = userDto.getPassword();
        userService.login(id,password);

        System.out.println("---------------session--------------------------");
        String before = (String)session.getAttribute("userId");
        System.out.println("before : "+before);

        if(session.getAttribute("userId") == null){
            session.setAttribute("userId", id);
        }
        System.out.println("---------------session--------------------------");
        String after = (String)session.getAttribute("userId");
        System.out.println("after : "+after );

        return REQUEST_OK;
    }

    @GetMapping("/stest")
    public String stest(HttpSession session){
        return (String)session.getAttribute("userId");
    }

    @GetMapping("/getSessionId")
    public String getSessionId(HttpSession session) {
        return session.getId();
    }

    @GetMapping("/all")
    public List<UserDto> findAll() {
        return userService.findAll();
    }


}

package com.dubu.party.domain.user.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // 로그 메시지를 출력
@Api(value = "유저 정보 API") // Swagger 라이브러리를 통해 사용
@RestController // 웹 애플리케이션의 RESTful 웹 서비스를 개발하기 위한 어노테이션
@RequestMapping("/api/users")
public class UserController {

//    @Autowired
//    UserService userService;
//    @Autowired
//    UserRepository userRepository;

}

package com.dubu.party.domain.user.controller;


import com.dubu.party.domain.user.db.entity.User;
import com.dubu.party.domain.user.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j // 로그 메시지를 출력
@Api(value = "유저 정보 API") // Swagger 라이브러리를 통해 사용
@RestController // 웹 애플리케이션의 RESTful 웹 서비스를 개발하기 위한 어노테이션
@RequestMapping("/api/users")
// api 요청들을 관리할 예정
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(
                userService.getAllUsers(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        System.out.println("===============");
        System.out.println("USER:"+user.getUserName());
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id,@RequestBody User user) {
        userService.updateUser(id, user);
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }
}

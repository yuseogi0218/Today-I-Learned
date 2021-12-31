package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {

    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);

        int a = 10 + age; // age 가 null 일 시 NullPointException 발생

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {

        System.out.println(user);
        return user;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class) // global 이 아닌 특정 클래스에만 적용 시키는 방법
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println(e.getLocalizedMessage());
        System.out.println("API Controller");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

package com.example.bookmanager.service;

import com.example.bookmanager.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void commentTest() {
        commentService.init();

        commentRepository.findAll().forEach(System.out::println);

        commentService.updateSomething();

        commentService.insertSomething();
    }

}

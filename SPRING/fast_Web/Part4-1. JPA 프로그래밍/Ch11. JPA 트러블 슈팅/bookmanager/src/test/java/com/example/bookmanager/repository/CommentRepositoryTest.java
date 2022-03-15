package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void commentTest() {
        Comment comment = commentRepository.findById(3L).get();

        comment.setCommentedAt(LocalDateTime.now());

        commentRepository.saveAndFlush(comment);

        entityManager.clear();

        System.out.println(commentRepository.findById(3L).get());

        Comment newComment = new Comment();
        newComment.setComment("별로에요");

        commentRepository.saveAndFlush(newComment);

        entityManager.clear();

        commentRepository.findAll().forEach(System.out::println);
    }
}
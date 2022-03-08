package com.example.bookmanager.service;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.domain.Book;
import com.example.bookmanager.repository.AuthorRepository;
import com.example.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Service
@RequiredArgsConstructor
public class BookService {

    private final EntityManager entityManager;

    private final BookRepository bookRepository;

    private final AuthorService authorService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void putBookAndAuthor() throws Exception {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        authorService.putAuthor();

        throw new Exception();
    }

    @Transactional
    public void get(Long id) {
        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        entityManager.clear();

        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        entityManager.clear();

    }
}

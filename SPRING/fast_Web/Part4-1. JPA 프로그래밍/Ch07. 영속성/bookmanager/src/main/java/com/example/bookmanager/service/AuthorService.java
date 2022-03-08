package com.example.bookmanager.service;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void putAuthor() {
        Author author = new Author();
        author.setName("martin");


        authorRepository.save(author);
    }

}

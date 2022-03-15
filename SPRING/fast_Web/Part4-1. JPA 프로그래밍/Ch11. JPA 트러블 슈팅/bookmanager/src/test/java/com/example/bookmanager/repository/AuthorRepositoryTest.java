package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.BookAndAuthor;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAndAuthorRepository bookAndAuthorRepository;

    @Test
    @Transactional
    void manyToManyTest() {
        Book book1 = givenBook("book_1");
        Book book2 = givenBook("book_2");

        Book book3 = givenBook("another_book_1");
        Book book4 = givenBook("another_book_2");

        Author author1 = givenAuthor("martin");
        Author author2 = givenAuthor("steve");

//        book1.addAuthor(author1);
        BookAndAuthor bookAndAuthor1 = givenBookAndAuthor(author1, book1);
//        book2.addAuthor(author2);
        BookAndAuthor bookAndAuthor2 = givenBookAndAuthor(author2, book2);
//
//        book3.addAuthor(author1, author2);
        BookAndAuthor bookAndAuthor3 = givenBookAndAuthor(author1, book3);
        BookAndAuthor bookAndAuthor4 = givenBookAndAuthor(author2, book3);

//        book4.addAuthor(author1, author2);
        BookAndAuthor bookAndAuthor5 = givenBookAndAuthor(author1, book4);
        BookAndAuthor bookAndAuthor6 = givenBookAndAuthor(author2, book4);

//        author1.addBook(book1, book3, book4);
//        author2.addBook(book2, book3, book4);

        book1.addBookAndAuthors(bookAndAuthor1);
        book2.addBookAndAuthors(bookAndAuthor2);
        book3.addBookAndAuthors(bookAndAuthor3, bookAndAuthor4);
        book4.addBookAndAuthors(bookAndAuthor5, bookAndAuthor6);

        author1.addBookAndAuthors(bookAndAuthor1, bookAndAuthor3, bookAndAuthor5);
        author2.addBookAndAuthors(bookAndAuthor2, bookAndAuthor4, bookAndAuthor6);

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2));

        // book3 조회
//        System.out.println("authors through book : " + bookRepository.findAll().get(2).getAuthors());
//        System.out.println("books through author : " + authorRepository.findAll().get(0).getBooks());

        bookRepository.findAll().get(2).getBookAndAuthors().forEach(o -> System.out.println(o.getAuthor()));

        authorRepository.findAll().get(0).getBookAndAuthors().forEach(o -> System.out.println(o.getBook()));
    }

    private Book givenBook(String name) {
        Book book = new Book();
        book.setName(name);

        return bookRepository.save(book);
    }

    private Author givenAuthor(String name) {
        Author author = new Author();
        author.setName(name);

        return authorRepository.save(author);
    }

    private BookAndAuthor givenBookAndAuthor(Author author, Book book) {
        BookAndAuthor bookAndAuthor = new BookAndAuthor();

        bookAndAuthor.setBook(book);
        bookAndAuthor.setAuthor(author);

        return bookAndAuthorRepository.save(bookAndAuthor);
    }
}
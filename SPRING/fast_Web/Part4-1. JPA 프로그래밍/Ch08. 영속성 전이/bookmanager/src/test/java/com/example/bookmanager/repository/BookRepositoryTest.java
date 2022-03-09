package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.Publisher;
import com.example.bookmanager.domain.Review;
import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("Jpa 초격차");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());

    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();

        User user = userRepository.findByEmail("martin@fastcampus.com");

        // 해당 사용자가 작성한 모든 리뷰 확인
        System.out.println("Review : " + user.getReviews());

        // 해당 사용자가 작성한 첫번째 리뷰의 책 확인
        System.out.println("Book : " + user.getReviews().get(0).getBook());

        // 해당 사용자가 작성한 첫번째 리뷰의 책의 출판사 확인
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());
    }

    @Test
    void bookCascadeTest() {
        Book book = new Book();
        book.setName("JPA 초격차 패키지");

        Publisher publisher = new Publisher();
        publisher.setName("패스트 캠퍼스");

//      연관관계 설정
        book.setPublisher(publisher);
        bookRepository.save(book);

        // 영속성 전이로 저장된다.
//        publisher.addBook(book);
//        publisherRepository.save(publisher);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        // 하위 항목의 값 변경 시 - merge 에 대한 cascade 필요
        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("슬로우 캠퍼스");

        bookRepository.save(book1);

        System.out.println("Publisher : " + publisherRepository.findAll());

        Book book2 = bookRepository.findById(1L).get();
        bookRepository.delete(book2);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

    }

    @Test
    void bookRemoveCascadeTest() {
        bookRepository.deleteById(1L);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers  : " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> {
            System.out.println(book.getPublisher());
        });
    }

    @Test
    void softDelte() {
        bookRepository.findAll().forEach(System.out::println);
    }

    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));

        System.out.println(publisherRepository.findAll());
    }

    private User givenUser() {
        return userRepository.findByEmail("martin@fastcampus.com"); // import.sql 을 통해서 들어가 있음
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 초격차 패키지");
        book.setPublisher(publisher);

        Book saved_book = bookRepository.save(book);

        // publisher 의 bookList 에 해당 책 추가
        publisher.getBookList().add(saved_book);
        publisherRepository.save(publisher);

        return bookRepository.findAll().get(0);
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("패스트 캠퍼스");

        return publisherRepository.save(publisher);
    }

    private void givenReview(User user, Book book) {

        Review review = new Review();
        review.setTitle("내 인생을 바꾼 책");
        review.setContent("너무너무 재미있고 즐거운 책이었어요.");
        review.setScore(5.0f);

        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }
}

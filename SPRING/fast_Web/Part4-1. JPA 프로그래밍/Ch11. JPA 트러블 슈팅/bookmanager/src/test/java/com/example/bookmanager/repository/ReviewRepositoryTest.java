package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    void reviewTest() {
        // Custom Query Fetch Join
        List<Review> reviewList = reviewRepository.findAllByFetchJoin();

        // @EntityGraph
        List<Review> reviewList1 = reviewRepository.findAllByEntityGraph();

//        System.out.println(reviewList);

//        System.out.println("전체를 가져왔습니다.");
//
//        System.out.println(reviewList.get(0).getCommentList());
//
//        System.out.println("첫번째 리뷰의 코멘트들을 가져왔습니다.");
//
//        System.out.println(reviewList.get(1).getCommentList());
//
//        System.out.println("두번째 리뷰의 코멘트들을 가져왔습니다.");

        reviewList.forEach(System.out::println);

        System.out.println();

        reviewList1.forEach(System.out::println);
    }
}

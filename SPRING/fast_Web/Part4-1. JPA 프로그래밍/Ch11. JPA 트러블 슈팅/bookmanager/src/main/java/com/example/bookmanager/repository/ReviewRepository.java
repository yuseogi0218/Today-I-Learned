package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select distinct r from Review r join fetch r.commentList")
    List<Review> findAllByFetchJoin();

    @EntityGraph(attributePaths = "commentList")
    @Query(value = "select r from Review r")
    List<Review> findAllByEntityGraph();

    @EntityGraph(attributePaths = "commentList")
    List<Review> findAll();
}
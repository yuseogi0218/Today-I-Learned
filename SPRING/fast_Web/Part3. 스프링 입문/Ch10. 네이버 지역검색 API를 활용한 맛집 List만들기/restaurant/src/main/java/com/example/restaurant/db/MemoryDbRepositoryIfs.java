package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {
    Optional<T> findById(int index); // index 로 찾음
    T save(T entity); // 저장
    void deleteById(int index); // index로 삭제
    List<T> findAll(); // 전체 조회
}

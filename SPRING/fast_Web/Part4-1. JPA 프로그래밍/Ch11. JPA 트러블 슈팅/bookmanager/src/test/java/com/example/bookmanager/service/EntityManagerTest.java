package com.example.bookmanager.service;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest() {
        // userRepository.findAll() 과 동일함
        System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }

    @Test
    void cacheFindTest() {
        // 3 번 모두 select 문 사용됨
        System.out.println(userRepository.findByEmail("martin@fastcampu.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampu.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampu.com"));

        // PK 로 조회
        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());

    }

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("marrrrrrtin");
        userRepository.save(user);

        System.out.println("--------------------");
        user.setName("marrrrrrtin@fastcampus.com");
        userRepository.save(user);

        System.out.println(userRepository.findAll());
    }
}

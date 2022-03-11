package com.example.bookmanager.service;

import com.example.bookmanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void put() {
        User user = new User();

        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");
        // 여기까지는 비영속 상태

        // userRepository.save(user) 와 동일함
        // 여기부터 영속 상태 - entityManager 에 의해 관리 되어야 함
        entityManager.persist(user);

//        // DB에 저장됨
//        user.setName("newUserAfterPersist");

        entityManager.detach(user);

        // DB에 저장안됨
        user.setName("newUserAfterPersist");

        // 명시적으로, 변경사항을 영속 상태로 올려 놓는다.
        entityManager.merge(user);

        // 변경 작업 drop
        entityManager.clear();
    }
}

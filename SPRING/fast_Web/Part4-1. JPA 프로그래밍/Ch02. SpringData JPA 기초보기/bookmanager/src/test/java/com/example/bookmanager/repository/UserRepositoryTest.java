package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest // SpringContext를 load하여 테스트에 활용한다.
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void crud() { // create, read, update, delete
        // 이름 기준 내림차순 정렬
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

        users.forEach(System.out::println);

        // 1번, 3번, 5번 정보 조회
        List<User> users1 = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
        users1.forEach(System.out::println);

        // 여러개의 객체들 저장
        User user1 = new User("jack", "jack@fastcampus.com");
        User user2 = new User("steve", "steve@fastcampus.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));

        userRepository.findAll().forEach(System.out::println);

        // Id로 조회
        User find_user = userRepository.getOne(1L);
        System.out.println(find_user);

        Optional<User> find_user1 = userRepository.findById(1L);
        System.out.println(find_user1);

        // Flush - DB 반영시점 조절
        userRepository.save(new User("new martin", "newmartin@fastcampus.com"));
        userRepository.flush();
        userRepository.findAll().forEach(System.out::println);

        // SaveAndFlush
        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));
        userRepository.findAll().forEach(System.out::println);

        // count
        long count = userRepository.count();

        // 해당 Id 존재 확인 - count query 활용
        boolean exists = userRepository.existsById(1L);

        // delete : select 후 Id를 찾고, 해당 Id로 delete 됨
        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));

        // deleteById : select 하여 해당 객체가 존재하는지 사전에 확인, 해당 Id로 delete 됨
        userRepository.deleteById(2L);

        // deleteAll - 전체 삭제 : select 후 객체 개수 만큼 delete 수행 -> 성능 이슈 -> deleteInBatch 사용
        // userRepository.deleteAll();

        // deleteAll - 특정 id들 삭제
        // userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));

        // deleteInBatch : select 문 실행 안하고, delete 문 한번만 실행
        // userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));

        // deleteInAllInBatch - delete만 실행
        // userRepository.deleteAllInBatch();

    }

    @Test
    void page() {
        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));

        System.out.println("page : " + users);
        // 총 개수
        System.out.println("total elements : " + users.getTotalElements());
        // 전체 페이지 개수
        System.out.println("total pages : " + users.getTotalPages());
        // 현재 피에지 기록 개수
        System.out.println("number of elements : " + users.getNumberOfElements());
        // sort
        System.out.println("sort : " + users.getSort());
        // size
        System.out.println("size : " + users.getSize());

        // 현재 페이지의 entity 들 출력
        users.getContent().forEach(System.out::println);

    }

    // like 쿼리문 실행
    // Query By Example
    @Test
    void qbe() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);

        userRepository.findAll(example).forEach(System.out::println);


        User user = new User();
        user.setEmail("slow");

        ExampleMatcher matcher1 = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example1 = Example.of(user, matcher1);

        userRepository.findAll(example1).forEach(System.out::println);
    }

    @Test
    void update() {
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-update@fastcamput.com");

        userRepository.save(user);

        User updated = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        System.out.println(updated);
    }

}
package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest // SpringContext를 load하여 테스트에 활용한다.
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

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

    @Test
    void select() {
        System.out.println(userRepository.findByName("dennis"));

        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));

        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));

        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));

        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));

        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));

        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));

        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));

        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@fastcampus.com"));

        System.out.println("findTop1ByName : " + userRepository.findTop2ByName("martin"));

        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));

        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));

        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));

        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "dennis"));

        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));

        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));

        System.out.println("findByIdIsNptNull : " + userRepository.findByIdIsNotNull());

        System.out.println("findByAdressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContaining : " + userRepository.findByNameContaining("rti"));

        System.out.println("findByNameLike : " + userRepository.findByNameLike("%rti%"));
    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName : " + userRepository.findTop2ByName("martin"));

        System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc("martin"));

        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));

        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));

        System.out.println("findByNameWithPaging : " + userRepository.findByName("martin", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();

        user.setName("martin");
        user.setEmail("martin2@fastcampust.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        // insert 문 실행
        userRepository.save(user);

        // select 문 실행
        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrtin");

        // update 문 실행
        userRepository.save(user2);

        // delete 문 실행
        userRepository.deleteById(4L);

    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        // user.setCreatedAt(LocalDateTime.now());
        // user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin2@fastcampus.com"));

    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));

    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("martin-new@fastcampus.com");
        user.setName("martin-new");

        // insert
        userRepository.save(user);

        user.setName("martin-new-new");

        // update
        userRepository.save(user);


        userHistoryRepository.findAll().forEach(System.out::println);
    }

}
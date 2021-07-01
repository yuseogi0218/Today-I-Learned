package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { // member 회원 객체 저장
    Member save(Member member);
    Optional<Member> findById(Long id); // optional - 값이 null일때 처리 하는 방법
    Optional<Member> findByName(String name);
    List<Member> findAll();

}

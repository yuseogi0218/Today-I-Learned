package hello.hellospring.repository;

import hello.hellospring.domain.Member;
// import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore(); // 각 메소드가 끝날때 마다 repository 초기화
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring"); // member 객체의 name 을 spring 으로 설정

        repository.save(member); // repository 에 member 객체 저장
        Member result = repository.findById(member.getId()).get(); // repository에 저장된 member를 id로 찾음

        // result 랑 초기에 선언된 Member가 같은지 확인
        //Assertions.assertEquals(result, member);
        assertThat(member).isEqualTo(result); // 이 방법이 더 간편함 - assertj.core.api.Assertions
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}

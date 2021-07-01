package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // key 값 생성 - 0,1,2,...


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); // store에 id : member 를 넣음.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.of(store.get(id)); // optional 로 null case 처리
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // lambda 식 - 값을 하나씩 같은지 체크
                .findAny();  // 체크 하는 중 맞는 거 하나라도 있으면 바로 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store에 저장 된 member 반환
    }

    public void clearStore() {
        store.clear();
    }
}

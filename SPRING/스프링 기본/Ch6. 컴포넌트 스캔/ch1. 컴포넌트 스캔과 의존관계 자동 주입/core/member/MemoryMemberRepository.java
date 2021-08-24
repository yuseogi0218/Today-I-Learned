package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component // 빈 자동 등록 됨
public class MemoryMemberRepository implements MemberRepository{
    // 저장소 생성
    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

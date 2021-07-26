package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //저장소 객체 생성
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

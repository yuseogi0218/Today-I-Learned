package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //저장소 객체 생성
    private final MemberRepository memberRepository;

    // 의존성 주입
    //외부(AppConfig)에서 MemberRepository 의 구현 객체를 할당 해 준다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

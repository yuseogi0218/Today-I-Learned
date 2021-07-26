package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//테스트 코드
public class MemberApp {
    public static void main(String[] args) {
        // AppConfig 에서 생성된 memberService 를 받아옴
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // 스프링 컨테이너에 객체 생성 및 주입 하여 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 기본적으로 메서드 이름으로 등록되기 때문에 해당 이름을 전달, 반환 타입 결정

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}

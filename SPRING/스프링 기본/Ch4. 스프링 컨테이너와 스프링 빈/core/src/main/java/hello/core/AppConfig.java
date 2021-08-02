package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//App 전체 동작 방식을 config(설정 및 구성) 한다.
@Configuration //설정 정보를 뜻하는 것
public class AppConfig {

    @Bean // 각 메소드를 스프링 컨테이너에 등록 된다.
    // 각 인터페이스의 구체적인 구현 객체를 설정(선택) 해 준다.
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 단지 어느 객체로 구현할지만 변경 해 주면 된다.
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    // 각 구현 객체를 생성 및 생성자를 통해서 주입해 준다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}

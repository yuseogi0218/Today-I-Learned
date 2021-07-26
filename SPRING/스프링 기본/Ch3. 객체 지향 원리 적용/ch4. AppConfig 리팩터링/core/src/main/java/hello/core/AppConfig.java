package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//App 전체 동작 방식을 config(설정 및 구성) 한다.
public class AppConfig {
    // 각 인터페이스의 구체적인 구현 객체를 설정(선택) 해 준다.
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    // 각 구현 객체를 생성 및 생성자를 통해서 주입해 준다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


}

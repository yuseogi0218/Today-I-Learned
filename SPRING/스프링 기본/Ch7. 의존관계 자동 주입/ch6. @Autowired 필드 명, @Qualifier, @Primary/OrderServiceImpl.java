package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    // 필수 의존관계 주입 하는것
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired // 등록시 생성자를 호출할때 의존관계를 주입한다. -> 생성자가 1개 일 시 @Autowired 생략 가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 주문 객체 생성
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // memberId 에 맞는 해당 member 객체 생성
        int discountPrice = discountPolicy.discount(member, itemPrice); // 고정 할인 정책에 따라서 member의 grade가 vip이면 고정 할인 정책에 따라서 1000원 할인 반환

        return new Order(memberId, itemName, itemPrice, discountPrice); // order 해당 데이터 넣어서 반환
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

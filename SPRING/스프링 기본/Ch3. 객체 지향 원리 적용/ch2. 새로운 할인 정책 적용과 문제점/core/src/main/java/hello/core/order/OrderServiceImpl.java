package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //클래스 구현
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 고정 할인 정책 -> 새로운 할인 정책 적용해야함
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 할인 정책 적용 -> DIP 위반
    private DiscountPolicy discountPolicy; // DIP, OCP 위반 문제 해결 -> Null Point Exception Error 발생

    // 주문 객체 생성
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // memberId 에 맞는 해당 member 객체 생성
        int discountPrice = discountPolicy.discount(member, itemPrice); // 고정 할인 정책에 따라서 member의 grade가 vip이면 고정 할인 정책에 따라서 1000원 할인 반환

        return new Order(memberId, itemName, itemPrice, discountPrice); // order 해당 데이터 넣어서 반환
    }


}

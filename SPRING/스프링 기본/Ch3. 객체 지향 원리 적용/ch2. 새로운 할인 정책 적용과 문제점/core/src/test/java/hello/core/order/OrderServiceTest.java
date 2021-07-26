package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    /**
     * Test : 주문 생성 및 할인 가격 적용 테스트
     */
    @Test
    void createOrder() {
        /**
         *given
         *주어진 상황 - 등급이 VIP 인 회원 memberA가 있다.
         */
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        /**
         * when
         * 해당 회원이 가격 10000인 itemA를 구매할 때
         */
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        /**
         * then
         * 주문의 할인가가 1000 과 같은지 테스트 수행
         */
        // order.getDiscountPrice() - 해당 주문의 할인 금액 받아오기
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}

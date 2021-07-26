package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    //성공 테스트
    @Test
    @DisplayName("VIP 는 10% 할인이 적용되어야 한다") // 테스트시 화면에 출력됨
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    //실패 테스트
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberBasic", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        // Assertions.assertThat(discount).isEqualTo(1000);
        assertThat(discount).isEqualTo(0);
    }
}
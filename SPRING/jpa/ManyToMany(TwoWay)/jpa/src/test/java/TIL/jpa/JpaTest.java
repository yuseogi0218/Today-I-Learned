package TIL.jpa;

import TIL.jpa.Domain.Member;
import TIL.jpa.Domain.Order;
import TIL.jpa.Domain.Product;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // 내장 DB (가짜 DB)로 테스트를 수행 - 단위 테스트
// replace = Replace.NONE : 실제 DB로 테스트 - 통합 테스트
@DataJpaTest
public class JpaTest {

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    @DisplayName("연관관계 저장 ")
    public void initTest() {

        Member member1 = new Member(0L, "회원1");
        Member member2 = new Member(1L, "회원2");
        entityManager.persist(member1);
        entityManager.persist(member2);

        Product product1 = new Product(0L, "상품1");
        Product product2 = new Product(1L, "상품2");
        entityManager.persist(product1);
        entityManager.persist(product2);

        // 회원 1의 상품 주문
        Order order1OfMember1 = new Order(0L, member1, product1, 2, LocalDateTime.now());
        Order order2OfMember1 = new Order(1L, member1, product2, 3, LocalDateTime.now());
        entityManager.persist(order1OfMember1);
        entityManager.persist(order2OfMember1);

        // 회원 2의 상품 주문
        Order order1OfMember2 = new Order(2L, member2, product1, 5, LocalDateTime.now());
        Order order2OfMember2 = new Order(3L, member2, product2, 7, LocalDateTime.now());
        entityManager.persist(order1OfMember2);
        entityManager.persist(order2OfMember2);

        entityManager.flush();
        entityManager.clear();
    }

    @AfterEach
    public void emFlush() {
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    @DisplayName("저장된 객체 결과 확인")
    public void saveTest() {

    }

    @Test
    @DisplayName("Entity Graph 를 사용한 조회 - 회원")
    public void readWithEntityGraphByMember() {
        Member member1 = entityManager.find(Member.class, 0L);
        List<Order> ordersOfMember1 = member1.getOrders();

        Assertions.assertEquals(2, ordersOfMember1.size());
        System.out.println(ordersOfMember1);
    }

    @Test
    @DisplayName("JPQL 을 사용한 조회 - 회원")
    public void readWithJPQLByMember() {
        String jpql = "select o from Order o where o.member.id = :memberId";

        List<Order> ordersOfMember1 = entityManager
                .createQuery(jpql, Order.class)
                .setParameter("memberId", 0L)
                .getResultList();

        Assertions.assertEquals(2, ordersOfMember1.size());
        System.out.println(ordersOfMember1);
    }

    @Test
    @DisplayName("Entity Graph 를 사용한 조회 - 상품")
    public void readWithEntityGraphByProduct() {
        Product product1 = entityManager.find(Product.class, 0L);
        List<Order> ordersOfProduct1 = product1.getOrders();

        Assertions.assertEquals(2, ordersOfProduct1.size());
        System.out.println(ordersOfProduct1);
    }

    @Test
    @DisplayName("JPQL 을 사용한 조회 - 회원")
    public void readWithJPQLByProduct() {
        String jpql = "select o from Order o where o.product.id = :productId";

        List<Order> ordersOfMember1 = entityManager
                .createQuery(jpql, Order.class)
                .setParameter("productId", 0L)
                .getResultList();

        Assertions.assertEquals(2, ordersOfMember1.size());
        System.out.println(ordersOfMember1);
    }

    @Test
    @DisplayName("회원1의 첫번째 주문 수정")
    public void update() {
        Member member1 = entityManager.find(Member.class, 0L);
        Order order1OfMember1 = member1.getOrders().get(0);

        order1OfMember1.setOrderAmount(10);
    }

    @Test
    @DisplayName("회원1의 첫번째 주문 취소")
    public void 주문객체삭제() {
        Member member1 = entityManager.find(Member.class, 0L);
        Order order1OfMember1 = member1.getOrders().get(0);

        entityManager.remove(order1OfMember1);
    }

}

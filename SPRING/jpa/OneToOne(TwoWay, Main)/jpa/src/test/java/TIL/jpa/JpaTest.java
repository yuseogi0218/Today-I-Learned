package TIL.jpa;

import TIL.jpa.Domain.Locker;
import TIL.jpa.Domain.Member;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.locks.Lock;

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

        Locker locker = new Locker(0L, "사물함");
        entityManager.persist(locker);

        Member member = new Member(0L, "회원");
        member.setLocker(locker);
        entityManager.persist(member);

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
    @DisplayName("Entity Graph 를 사용한 조회 - 주 테이블")
    public void readWithEntityGraphByMain() {
        Member member = entityManager.find(Member.class, 0L);
        Locker locker = member.getLocker();

        Assertions.assertEquals(0L, locker.getId());
        Assertions.assertEquals("사물함", locker.getName());
    }

    @Test
    @DisplayName("JPQL 을 사용한 조회 - 주 테이블")
    public void readWithJPQLByMain() {
        String jpql = "select m.locker from Member m where m.id = :memberId";

        Locker locker = entityManager
                .createQuery(jpql, Locker.class)
                .setParameter("memberId", 0L)
                .getSingleResult();

        Assertions.assertEquals(0L, locker.getId());
        Assertions.assertEquals("사물함", locker.getName());
    }

    @Test
    @DisplayName("Entity Graph 를 사용한 조회 - 대상 테이블")
    public void readWithEntityGraphByTarget() {
        Locker locker = entityManager.find(Locker.class, 0L);
        Member member = locker.getMember();

        Assertions.assertEquals(0L, member.getId());
        Assertions.assertEquals("회원", member.getUsername());
    }

    @Test
    @DisplayName("JPQL 을 사용한 조회 - 대상 테이블")
    public void readWithJPQLByTarget() {
        String jpql = "select l.member from Locker l where l.id = :lockerId";

        Member member = entityManager
                .createQuery(jpql, Member.class)
                .setParameter("lockerId", 0L)
                .getSingleResult();

        Assertions.assertEquals(0L, member.getId());
        Assertions.assertEquals("회원", member.getUsername());
    }

    @Test
    @DisplayName("신규 사물함으로 수정")
    public void update() {
        Locker locker = new Locker(1L, "신규 사물함");
        entityManager.persist(locker);

        Member member = entityManager.find(Member.class, 0L);
        member.setLocker(locker);
    }

    @Test
    @DisplayName("연관관계 제거")
    public void 연관관계제거() {
        Member member = entityManager.find(Member.class, 0L);
        member.setLocker(null);
    }

    @Test
    @DisplayName("회원 객체 삭제")
    public void 회원객체삭제() {
        Member member = entityManager.find(Member.class, 0L);
        entityManager.remove(member);
    }
}

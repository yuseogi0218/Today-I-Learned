package TIL.jpa;

import TIL.jpa.Domain.Member;
import TIL.jpa.Domain.Team;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // 내장 DB (가짜 DB)로 테스트를 수행 - 단위 테스트
// replace = Replace.NONE : 실제 DB로 테스트 - 통합 테스트
@DataJpaTest
public class JpaTest {

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void teamSave() {

        // 팀 1 저장
        Team team1 = new Team(0L, "팀1");
        entityManager.persist(team1); // 영속화

        // 회원 1 저장
        Member member1 = new Member(0L, "회원1");
        member1.setTeam(team1); // 연관관계 설정 member1 → team1
        entityManager.persist(member1);

        // 회원 2 저장
        Member member2 = new Member(1L, "회원2");
        member2.setTeam(team1); // 연관관계 설정 member2 → team1
        entityManager.persist(member2);

        entityManager.flush();
        entityManager.clear();
    }

    @AfterEach
    public void entityManagerClear() {
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    @DisplayName("회원과 팀 정보를 출력하는 비즈니스 로직")
    public void printUserAndTeam() {
        Member member = entityManager.find(Member.class, 0L);
        Team team = member.getTeam();

        System.out.println("회원 이름 : " + member.getUsername());
        System.out.println("팀 이름 : " + team.getName());
    }

    @Test
    @DisplayName("회원 정보만 출력하는 비즈니스 로직")
    public void printUser() {
        Member member = entityManager.find(Member.class, 0L);

        System.out.println("회원 이름 : " + member.getUsername());
    }

    @Test
    @DisplayName("proxy 객체를 활용한 회원 정보만 출력하는 비즈니스 로직")
    public void printUserWithProxy() {
        Member member = entityManager.getReference(Member.class, 0L);

        System.out.println("before use member entity");
        System.out.println("회원 이름 : " + member.getUsername());
    }

    @Test
    @DisplayName("proxy 객체와 원본 entity 객체의 타입 체크")
    public void typeCheckWithProxyAndWithoutProxy() {
        Member member = entityManager.find(Member.class, 0L);
        Member memberWithProxy = entityManager.getReference(Member.class, 1L);

        System.out.println("member 클래스 : " + member.getClass());
        System.out.println("memberWithProxy 클래스 : " + memberWithProxy.getClass());
        Assertions.assertNotSame(member.getClass(), memberWithProxy.getClass());

        Assertions.assertTrue(member instanceof Member);
        Assertions.assertTrue(memberWithProxy instanceof Member);
    }

    @Test
    @DisplayName("proxy Utils")
    public void proxyUtils() {
        EntityManagerFactory emf = entityManager.getEntityManagerFactory();
        Member memberWithProxy = entityManager.getReference(Member.class, 0L);

        boolean isLoaded = emf.getPersistenceUnitUtil().isLoaded(memberWithProxy);
        Assertions.assertFalse(isLoaded);

        // proxy 강제 초기화
        Hibernate.initialize(memberWithProxy);
        boolean isLoadedAfterInit = emf.getPersistenceUnitUtil().isLoaded(memberWithProxy);
        Assertions.assertTrue(isLoadedAfterInit);
    }
}


package TIL.jpa;

import TIL.jpa.Domain.Member;
import TIL.jpa.Domain.Team;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // 내장 DB (가짜 DB)로 테스트를 수행 - 단위 테스트
// replace = Replace.NONE : 실제 DB로 테스트 - 통합 테스트
@DataJpaTest
public class JpaTest {

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    @DisplayName("JPA 지연로딩을 활용한 양방향 연관관계 매핑")
    public void initTest() {
        Team team1 = new Team(0L, "팀1");
        entityManager.persist(team1);

        Member member1 = new Member(0L, "회원1");
        Member member2 = new Member(1L, "회원2");

        // 연관관계의 주인에 값 설정
        member1.setTeam(team1);
        member2.setTeam(team1);

        entityManager.persist(member1);
        entityManager.persist(member2);

        // 역방향 연관관계를 설정하지 않아도, 지연 로딩을 통해서 아래에서 Member에 접근할 수 있다.
        //team.getMembers().add(member);

        // 이 동작이 수행되지 않으면 FK가 설정되어 있지 않은 1차캐시에만 영속화 된 상태이다.
        // SELECT 쿼리로 조회해봤자 list 사이즈 0이다.
        entityManager.flush();
        entityManager.clear();
    }

    @AfterEach
    public void emFlush() {
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    @DisplayName("JPA 를 활용하지 않은 순수한 객체")
    public void savePOJOTest() {

        // 팀 및 회원 객체 생성
        Team team = new Team(0L, "팀1");
        Member member1 = new Member(0L, "회원1");
        Member member2 = new Member(0L, "회원2");

        member1.setTeam(team);
        member2.setTeam(team);

        List<Member> members = team.getMembers();
        System.out.println("members.size = " + members.size());

        Assertions.assertEquals(2, members.size());
    }

    @Test
    @DisplayName("저장된 객체 결과 확인")
    public void saveTest() {
        Team findTeam = entityManager.find(Team.class, 0L);
        List<Member> findMembers = findTeam.getMembers();

        Assertions.assertEquals(2, findMembers.size());
    }

    @Test
    @DisplayName("연관관계의 주인인 '다' 에서의 조회")
    public void readByManyWithEntityGraph() {
        Member member1 = entityManager.find(Member.class, 0L);

        // member1 에 속한 Team 조회
        Team team = member1.getTeam();

        Assertions.assertEquals(0L, team.getId());
        Assertions.assertEquals("팀1", team.getName());
    }

    @Test
    @DisplayName("연관관계의 주인인 '다' 에서의 조회")
    public void readByManyWithJPQL() {
        String jpql = "select t from Team t join Member m on t.id = m.team.id "
                + "where m.id = :memberId";

        Team team = entityManager.createQuery(jpql, Team.class)
                .setParameter("memberId", 0L)
                .getSingleResult();

        Assertions.assertEquals(0L, team.getId());
        Assertions.assertEquals("팀1", team.getName());
    }

    @Test
    @DisplayName("연관관계의 주인이 아닌 '일' 에서의 조회")
    public void readByOneWithEntityGraph() {
        Team team = entityManager.find(Team.class, 0L);

        List<Member> members = team.getMembers();

        Assertions.assertEquals(2, members.size());
        for (Member member : members) {
            System.out.println("member id : " + member.getId().toString() + ", name : " + member.getUsername());
        }
    }

    @Test
    @DisplayName("연관관계의 주인이 아닌 '일' 에서의 조회")
    public void readByOneWithJPQL() {
        String jpql = "select m from Member m join m.team t on t.id = m.team.id "
                + "where t.id = :teamId";

        List<Member> members = entityManager.createQuery(jpql, Member.class)
                .setParameter("teamId", 0L)
                .getResultList();

        Assertions.assertEquals(2, members.size());
        for (Member member : members) {
            System.out.println("member id : " + member.getId().toString() + ", name : " + member.getUsername());
        }
    }

    @Test
    @DisplayName("연관관계 수정")
    public void updateRelation() {
        Team team2 = new Team(1L, "팀2");
        entityManager.persist(team2);

        Member member1 = entityManager.find(Member.class, 0L);
        member1.setTeam(team2);

        Assertions.assertEquals(1L, member1.getTeam().getId());
        Assertions.assertEquals("팀2", member1.getTeam().getName());
    }

    @Test
    @DisplayName("연관관계 제거 후 객체 삭제")
    public void deleteRelation() {
        Team team1 = entityManager.find(Team.class, 0L);

        // Member 와의 연관관계를 제거합니다.
        List<Member> members = team1.getMembers();
        while (members.size() > 0) {
            members.get(0).setTeam(null);
        }

        entityManager.remove(team1);
    }
}

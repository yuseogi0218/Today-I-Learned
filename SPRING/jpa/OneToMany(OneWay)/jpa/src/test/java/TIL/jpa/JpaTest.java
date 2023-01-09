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
    @DisplayName("연관관계 저장 ")
    public void initTest() {

        Member member1 = new Member(0L, "회원1");
        Member member2 = new Member(1L, "회원2");

        entityManager.persist(member1);
        entityManager.persist(member2);


        Team team1 = new Team(0L, "팀1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);
        entityManager.persist(team1);

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
        Team findTeam = entityManager.find(Team.class, 0L);
        List<Member> findMembers = findTeam.getMembers();

        Assertions.assertEquals(2, findMembers.size());
    }

    @Test
    @DisplayName("Entity Graph 를 사용한 조회")
    public void readWithEntityGraph() {
        Team team = entityManager.find(Team.class, 0L);
        List<Member> findMembers = team.getMembers();

        Assertions.assertEquals(2, findMembers.size());
    }

    @Test
    @DisplayName("orphanRemoval = true 삭제 옵션")
    public void deleteWithOrphanRemovalTrue() {
        Team team = entityManager.find(Team.class, 0L);

        entityManager.remove(team);
    }
}

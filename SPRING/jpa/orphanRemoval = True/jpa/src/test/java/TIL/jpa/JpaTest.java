package TIL.jpa;

import TIL.jpa.Domain.Member;
import TIL.jpa.Domain.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // 내장 DB (가짜 DB)로 테스트를 수행 - 단위 테스트
// replace = Replace.NONE : 실제 DB로 테스트 - 통합 테스트
@DataJpaTest // @Transactional 포함하고 있음
public class JpaTest {

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void initTest() {
        Team team = new Team(0L, "팀1");
        entityManager.persist(team);

        Member member1 = new Member(0L, "회원1");
        Member member2 = new Member(1L, "회원2");

        // 연관관계의 주인에 값 설정
        member1.setTeam(team);
        member2.setTeam(team);

        // CascadeType.PERSIST 로 인하여 영속성 전이
//        entityManager.persist(member1);
//        entityManager.persist(member2);

        // 이 동작이 수행되지 않으면 FK가 설정되어 있지 않은 1차캐시에만 영속화 된 상태이다.
        // SELECT 쿼리로 조회해봤자 list 사이즈 0이다.
        entityManager.flush();
    }

    @DisplayName("부모 엔티티(Team)을 삭제하는 경우")
    @Test
    public void orphanRemoval_true_Parent() {
        // when
        Team team = entityManager.find(Team.class, 0L);
        entityManager.remove(team);

        entityManager.flush();

        // then
        List<Team> teamList = entityManager.createQuery("select t from Team t", Team.class).getResultList();
        Assertions.assertEquals(0, teamList.size());

        List<Member> memberList = entityManager.createQuery("select m from Member m", Member.class).getResultList();
        Assertions.assertEquals(0, memberList.size());

    }

    @DisplayName("고아객체 - 부모 엔티티(Team)에서 자식 엔티티(Member)와 연관관계를 끊는 경우")
    @Test
    public void orphanRemoval_true_Persistence_Remove() {
        // when
        Team team = entityManager.find(Team.class, 0L);
        team.getMembers().get(0).setTeam(null);

        entityManager.flush();

        // then
        List<Team> teamList = entityManager.createQuery("select t from Team t", Team.class).getResultList();
        Assertions.assertEquals(1, teamList.size());

        List<Member> memberList = entityManager.createQuery("select m from Member m", Member.class).getResultList();
        Assertions.assertEquals(1, memberList.size());
    }

    @DisplayName("자식 엔티티의 연관관계 변경 시")
    @Test
    public void change_persistence_child() {
        // given
        Team team = new Team(1L, "팀2");
        entityManager.persist(team);

        // when
        Member member1 = entityManager.find(Member.class, 0L);
        member1.setTeam(team); // DELETE, INSERT 쿼리 수행
        entityManager.flush();

        // then
        Team team1 = entityManager.createQuery("select t from Team t where t.id = 0", Team.class).getSingleResult();
        Assertions.assertEquals(1L, team1.getMembers().get(0).getId());

        Team team2 = entityManager.createQuery("select t from Team t where t.id = 1", Team.class).getSingleResult();
        Assertions.assertEquals(0L, team2.getMembers().get(0).getId());

        List<Member> memberList = entityManager.createQuery("select m from Member m", Member.class).getResultList();
        Assertions.assertEquals(2, memberList.size());
    }

}

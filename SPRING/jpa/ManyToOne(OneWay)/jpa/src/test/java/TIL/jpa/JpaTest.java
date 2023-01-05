package TIL.jpa;

import TIL.jpa.Domain.Member;
import TIL.jpa.Domain.Team;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // 내장 DB (가짜 DB)로 테스트를 수행 - 단위 테스트
// replace = Replace.NONE : 실제 DB로 테스트 - 통합 테스트
@DataJpaTest
public class JpaTest {

    @Autowired
    private EntityManager em;

    @BeforeEach
    public void teamSave() {

        // 팀 1 저장
        Team team1 = new Team(0L, "팀1");
        em.persist(team1); // 영속화

        // 회원 1 저장
        Member member1 = new Member(0L, "회원1");
        member1.setTeam(team1); // 연관관계 설정 member1 → team1
        em.persist(member1);

        // 회원 2 저장
        Member member2 = new Member(1L, "회원2");
        member2.setTeam(team1); // 연관관계 설정 member2 → team1
        em.persist(member2);

        em.flush();
        em.clear();
    }

    @AfterEach
    public void entityManagerClear() {
        em.flush();
        em.clear();
    }

    @Test
    public void readGraphTest() {
        Member member = em.find(Member.class, 0L);
        Team team = member.getTeam();
        System.out.println(team.getName());
    }

    @Test
    public void readJPQLTest() {
        String jpql = "select t from Team t join Member m on t.id = m.team.id "
                + "where m.id = :memberId";

        Team team = em.createQuery(jpql, Team.class)
                .setParameter("memberId", 0L)
                .getSingleResult();
        System.out.println("팀 이름 = " + team.getName());
    }

    @Test
    public void updateTest() {
        // 새로운 팀2 영속화
        Team team2 = new Team(1L, "팀2");
        em.persist(team2);

        // 회원1에 새로운 팀2 설정
        Member member = em.find(Member.class, 0L);
        member.setTeam(team2);
    }

    @Test
    public void deleteTest() {
        Member member1 = em.find(Member.class, 0L);
        member1.setTeam(null);

        Member member2 = em.find(Member.class, 1L);
        member2.setTeam(null);

        Team team = em.find(Team.class, 0L);
        em.remove(team);
    }

}


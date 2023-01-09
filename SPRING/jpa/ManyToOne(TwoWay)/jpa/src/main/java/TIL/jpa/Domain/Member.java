package TIL.jpa.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // 연관관계 편의 메서드
    public void setTeam(Team team) {

        // 기존 팀과 연관관계를 제거
        if (this.team != null) {
            this.team.getMembers().remove(this);
        }


        // 새로운 연관관계 설정
        this.team = team;
        if (team != null) {
            team.getMembers().add(this);
        }
    }

}

package TIL.jpa.Domain;

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

    @ManyToOne // @ManyToOne 의 속성 fetch 의 기본값 은 FetchType.EAGER
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
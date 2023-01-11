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

    @OneToOne(mappedBy = "member")
    private Locker locker;

    @Column(name = "USERNAME")
    private String username;

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }

}

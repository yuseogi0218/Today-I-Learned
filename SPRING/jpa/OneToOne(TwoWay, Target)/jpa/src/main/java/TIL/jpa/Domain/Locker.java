package TIL.jpa.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Locker {

    @Id
    @Column(name = "LOCKER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public Locker(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.setLocker(null);
        }

        this.member = member;
        if (member != null) {
            member.setLocker(this);
        }
    }
}

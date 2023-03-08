package TIL.jpa.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(
            mappedBy = "team",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST}
    )
    private List<Member> members = new ArrayList<>();

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}

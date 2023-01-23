package TIL.jpa.Domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private Long id;


    @Column(name = "NAME")
    private String name;

}

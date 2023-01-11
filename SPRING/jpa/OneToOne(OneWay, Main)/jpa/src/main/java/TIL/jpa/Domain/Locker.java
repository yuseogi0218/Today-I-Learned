package TIL.jpa.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Locker {

    @Id
    @Column(name = "LOCKER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}

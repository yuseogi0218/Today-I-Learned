package TIL.jpa.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "member") // 연결 테이블(ORDER)쪽이 외래키를 갖고있기 때문에, 연결 테이블이 연관관계의 주인이다.
    private List<Order> orders = new ArrayList<>();

    @Column(name = "USERNAME")
    private String username;

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }

}

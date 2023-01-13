package TIL.jpa.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    @OneToMany(mappedBy = "product") // 연결 테이블(ORDER)쪽이 외래키를 갖고있기 때문에, 연결 테이블이 연관관계의 주인이다.
    private List<Order> orders;

    @Column(name = "NAME")
    private String name;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

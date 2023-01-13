package TIL.jpa.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "ORDERS")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "ORDERAMOUNT")
    private Integer orderAmount;

    @Column(name = "ORDERDATE")
    private LocalDateTime orderDate;

    public Order(Long id, Member member, Product product, Integer orderAmount, LocalDateTime orderDate) {
        this.id = id;
        this.member = member;
        this.product = product;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", member=" + member.getUsername() +
                ", product=" + product.getName() +
                ", orderAmount=" + orderAmount +
                ", orderDate=" + orderDate +
                '}';
    }
}

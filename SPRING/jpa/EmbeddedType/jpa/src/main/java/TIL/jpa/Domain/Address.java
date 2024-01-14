package TIL.jpa.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@NoArgsConstructor
@Embeddable
public class Address {

    private String state;
    @Column(name = "city") // 매핑할 컬럼 정의 가능
    private String city;
    private String street;
    @Embedded
    private Zipcode zipcode;
}

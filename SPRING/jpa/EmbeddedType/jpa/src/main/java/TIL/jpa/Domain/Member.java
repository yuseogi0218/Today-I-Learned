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

    @Embedded
    Period workPeriod; // 근무 기간

    @Embedded
    Address homeAddress; // 집 주소

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "state", column = @Column(name = "COMPANY_STATE")),
            @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET")),
            @AttributeOverride(name = "zipcode.zip", column = @Column(name = "COMPANY_ZIP")),
            @AttributeOverride(name = "zipcode.plusFour", column = @Column(name = "COMPANY_PLUS_FOUR")),
    })
    Address companyAddress; // 회사 주소
}

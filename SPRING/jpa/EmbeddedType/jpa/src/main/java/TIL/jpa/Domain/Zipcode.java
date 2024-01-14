package TIL.jpa.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@Embeddable
public class Zipcode {

    private String zip;
    private String plusFour;

}

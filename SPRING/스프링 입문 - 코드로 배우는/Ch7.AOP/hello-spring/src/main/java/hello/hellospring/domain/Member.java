package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class  Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB 가 알아서 생성
    private  Long id; // 임의의 값 - 데이터를 구분하기 위한 것
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

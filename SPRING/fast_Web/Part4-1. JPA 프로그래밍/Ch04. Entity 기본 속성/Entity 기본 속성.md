### @Entity
- 해당 객체가 JPA 에서 관리하고 있는 Entity 객체임을 정의합니다.
- @ID 를 통해 PK 지정
    - @GeneratedValue 를 통해 기본키 생성을 DB에 위임
        - strategy
            - IDENTITY : MySQL에서 많이 사용하는 전략 - Auto Increasement, 특정 ID 값이 비어있는 현상 발생
            - SEQUENCE : Oracle, PostgreSql 에서 많이 사용하는 전략 - Sequence를 제공하는 sql - insert문이 실행될때 값 증가
            - TABLE : DB의 종류에 상관없이, ID 값을 관리하는 테이블을 만들어 가져다 쓰는 전략
            - AUTO : default 값, DB의 종류에 상관없이 사용 가능
- 속성 타입 지정
    - Primitive 타입
        - Null 값 허용 안함
    - Reference 타입
        - Null 값 허용 함
            
### @Table
- DB 테이블 구성 설정 가능 
    - 이름, schema, uniqueConstraint, index, ...
    - 실제 DB에 적용하는 것과 다르게 될 수 있다.
        - index를 활용한 쿼리가 동작하는 것이 아니다?

### @Column
- 각 필드의 속성 설정
    - 이름, unique, nullable, insertable, updatable, size, ...
    - insertable -> insert 쿼리문 작동 시 적용 안됨
    - updatable -> update 쿼리문 작동 시 적용 안됨

### @Transient
- DB 와 별개의 객체 만의 속성으로 활용
- 영속성 처리에서 제외가 된다.

### @Enumerated - Enum에 대한 처리 방법
- value 속성
    - default : ordinal -> enum 의 순서대로 DB에 저장된다.
    - **EnumType.STRING -> enum 값 그대로 저장됩니다.**

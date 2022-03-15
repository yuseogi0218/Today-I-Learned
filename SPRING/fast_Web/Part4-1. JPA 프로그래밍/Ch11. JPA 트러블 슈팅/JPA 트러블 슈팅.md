### FetchType
- Entity들 사이에 연관관계가 존재합니다.
- 각 연관관계마다 default값이 다름
- Eager : 항상 연관관계가 맺어진 Entity를 불러온다.
- Lazy : 필요할 때만 해당 연관관계가 맺어진 Entity를 불러온다.
    - 필요한 시점 : Getter를 사용할 때 해당 Entity 조회 쿼리가 실행된다.
    - session이 열러있을때만 가능하다. - session : 영속성 컨텍스트가 해당 Entity를 관리하고 있는 시점 (@Transactional)

### 01. N+1 이슈
- 연관관계가 맺어진 Entity를 조회시, 이어진 Entity에 대한 조회가 한번 더 실행이 되는 이슈
- 1. Custom Query로 Fetch Join을 작성하여 해결한다.
    ``` java 
        @Query(value = "select distinct r from Review r join fetch r.commentList")
        List<Review> findAllByFetchJoin();
    ```

- 2. @EntityGraph
    ``` java
        @EntityGraph(attributePaths = "commentList")
        @Query(value = "select r from Review r")
        List<Review> findAllByEntityGraph();
    ```

### 02. 영속성 컨텍스트로 인해 발생하는 이슈
- 영속성 컨텍스트가 가지고 있는 캐시로 인해서 발생하는 DB데이터와의 불일치 이슈
- @DynamicInsert
    - insert 시점에 Dynamic 하게 정의함
    - insert 시점에 값이 존재하는 것만 insert 쿼리문이 실행됨

### 03. 배치쿼리 성능 이슈 (JPA에서 DirtyCheck와 성능 이슈)
- save를 하지 않았지만 객체에 대해서 값을 변경하였을 경우 JPA 가 Transaction 종료 시, 값을 저장해줌
- @Transactional(readOnly = true) 하면 저장되지 않음?

## 01. JPA Repopsitory Interface 상세
- ### @Entity
    - ORM - DB Table 과 JAVA 객체간의 연결을 만들어 준다.
    - Entity - ORM 에서 JAVA 객체에 해당 하는 것
    - @Entity를 통해서 Entity로 선언 가능
        - PK가 반드시 필요하다.
        - @ID , @GeneratedValue private Long id를 통해서 PK 지정
    - Repository Interface 생성
        - JpaRepository<Entity type , PK type> 상속(extends)

- JpaRepository
    - flush
        - 현재 JPA Context에 갖고있는 DB 값을 DB에 반영하도록 하는 method
    - saveAndFlush
        - 저장한 값을 JPA Context에 갖고있지 말고, 바로 DB에 반영하도록 하는 method
    - deleteInBatch
        - entity들을 입력 받은 후 DB에서 제거하는 method

- CRUDRepository
    - findAll(sort)
        - findAll(Sort.by(Direction.DESC), "field 이름")
        - 해당 field 기준 내림차순 정렬 조회
    - findAllById( List\<Long>)
        - findAllById(Lists.newArrayList(1L, 3L, 5L))
        - 해당하는 Id 들의 객체 조회
    - saveAll( List\<Entity>)
        - 여러 객체들 저장
    - getOne(Long)
        - LazyFetch 지원
        - @Transactional 필요
        ```python
        public T getOne(ID id) {

		Assert.notNull(id, ID_MUST_NOT_BE_NULL);
		return em.getReference(getDomainClass(), id);
        }
        ```
    - findById(Long)
        - return : Optional\<Entity>
        ```python
        @Override
        public Optional<T> findById(ID id) {

            Assert.notNull(id, ID_MUST_NOT_BE_NULL);

            Class<T> domainType = getDomainClass();

            if (metadata == null) {
                return Optional.ofNullable(em.find(domainType, id));
            }

            LockModeType type = metadata.getLockModeType();

            Map<String, Object> hints = new HashMap<>();
            getQueryHints().withFetchGraphs(em).forEach(hints::put);

            return Optional.ofNullable(type == null ? em.find(domainType, id, hints) : em.find(domainType, id, type, hints));
        }
        ```

        - count : return long
            - 데이터 개수 반환
- 최상위 Repository
    - Jpa에서 사용하는 domain repository인 것을 알려주기 위한 것?
    
- data.sql
    - spring 2.5.2 version 부터 import.sql로 변경됨

- ### paging
    - Page\<Entity> entities - entityRepository.findAll(PageRequest.of(page, size))
        - page : 현재 페이지 지정
        - size : 페이지의 크기 지정
    - 총 개수
        - entities.getTotalElements();
    - 전체 페이지 개수
        - entities.getTotalPages();
    - 현재 피에지 기록 개수
        - entities.getNumberOfElements();
    - sort
        - entities.getSort();
    - size
        - entities.getSize();

    - 현재 페이지의 entity 들 출력
        - entities.getContent().forEach(System.out::println);

- ### QueryByExample
    - Entity를 Example로 만들어서 matcher를 선언하여 필요로 되는 쿼리문을만드는 것
    - like 쿼리문 실행
    - ``` python
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", 검색 방식);

        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);

        userRepository.findAll(example).forEach(System.out::println);
        ```
    - 검색 방식
        - endWith()
            - 끝 맞춤
        - contains()
            - 양 방향 맞춤

### 02. Simple Jpa Repository 분석
- JpaRepositoryImplementation 구현
- ### update
    - .save(Entity) 를 통하여 Update
        - ```python
        @Transactional
        @Override
        public <S extends T> S save(S entity) {

                Assert.notNull(entity, "Entity must not be null.");

                if (entityInformation.isNew(entity)) {
                    em.persist(entity);
                    return entity;
                } else {
                    return em.merge(entity);
                }
            }
        ```

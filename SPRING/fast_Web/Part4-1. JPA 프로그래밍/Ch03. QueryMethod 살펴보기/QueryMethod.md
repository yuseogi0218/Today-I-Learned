### QueryMethod

- ### 정의
    - 메소드의 이름만으로 필요한 쿼리를 만들어 내는 기능으로, 네이밍 룰만 알고 있어도 사용할 수 있다.

- ### Select 문
    - findBy, getBy, readBy, queryBy, searchBy, streaBy, find...By 모두 다 동일한 쿼리문 사용
    
    - findSomethingByEmail
        - 해당 문자열 자체가 구현체에서 무시됨
        - 자유도를 제공하는 만큼, 잘못된 정보가 전달되지 않도록 잘 사용해야 함

- ### First\<number>, Top\<number> 
    - 목록 중 상위 number개 반환
    - Limit 쿼리 문 사용
    - Last문은 존재 하지 않음
        - OrderBy 문으로 정렬 후 앞의것 가져옴

- ### And, Or 문
    - findBy...And...
    - findBy...Or...

- ### After, Befor 문 - Equal 포함 안함
    - 시간에 대한 조건 
    - findByCreatedAtAfter → 특정 날짜 이후
    - findByCreatedAtBefore → 특정 날짜 이전
    - > 쿼리문 사용

- ### GreaterThan, LessThan 문
    - 특정 값 비교하는 조건
    - findBy...GreaterThan → 특정 값 보다 큰 객체들
    - findBy...GreaterThanEqual → 특정 값 보다 크거나 같은 객체들
    - findBy...LessThan → 특정 값 보다 작은 객체들
    - findBy...LessThanEqual → 특정 값 보다 작거나 같은 객체들

- ### Between 문
    - 날짜와 숫자로 특정 범위 안에 있는 객체들 조회
    - findBy...Between(이전, 이후)
    - 양 끝 지점 포함
    - == findBy...GreaterThanEqualAnd...LessThanEqual

- ### IsNull, IsNotNull
    - 특정 값이 Null인지 아닌지 확인하는 구문
    - findBy...IsNull
    - findBy...IsNotNull

- ### IsEmpty, IsNotEmpty
    - 특정 값이 Collection 타입의 "" 인지 아닌지 확인하는 구문

- ### True, False
    - 특정 조건의 참, 거짓 확인하는 구문

- ### In, NotIn
    - 주어지는 리스트내의 값이 있는것들 조회
    - findBy...In(List<객체의 특성>)

- ### Containing(또는 Contains), StartingWith, EndingWith
    - 문자열에 대한 Like 쿼리문
    - findBy...StartingWith()
        - findBy...Like(%...)
    - findBy...EndingWith()
        - findBy...Like(...%)
    - findBy...Containing()
        - findBy...Like(%...%)

- ### Is
    - 코드 가독성을 높여줌
    - findBy...Is == findBy...

### QueryMethod 로 정렬해보기
- ### OrderBy...Desc, OrderBy...Asc
    - findTop1By...OrderBy...Desc - 내림차순으로 정렬 후, 가장 상위값 하나 조회
    - 다중 정렬 시, 뒤에 그대로 이어붙여주면 됨
        - findFirstByNameOrderByIdDescEmailAsc

- ### PagingAndSortingRepository 활용하여 정렬
    - find...(Sort) → findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))
    - 위 방법을 활용하여 메소드 이름을 간결하게 한다. → 코드의 가독성 향상

### QueryMethod로 페이징 처리하기
- ### 리턴값 Page\<Entity> 로 QueryMethod 선언
    - 쿼리메서드의 파라미터에 Pageable 추가
        - PageRequest.of(int page, int size, Sort sort)
    - Slice - 현재 페이지에 대한 정보
    - Page 
        - Slice 상속
        - 전체 페이지에 대한 정보
        - getContent - 페이징이 처리가 된 현재 페이지의 실제 객체들 확인
    - Pageable
        - Paging 을 요청하는 값

## JUnit 이란
- ### TDD (Test Driven Development)
    - 테스트 주도 개발에서 사용하지만, 코드의 유지 보수 및 운영 환경에서의 에러를 미리 방지 하기 위해서 단위 별로 검증 하는 테스트 프레임워크

- ### 단위 테스트
    - 작성한 코드가 기대하는 대로 동작을 하는지 검증하는 절차

- ### JUnit
    - Java 기반의 단위 테스트를 위한 프레임워크
    - Annotation 기반으로 테스트를 지원
    - Assert를 통하여 ,(예상, 실제)를 통해 검증
    
## 테스트 커버리지 확인하기
- ### Jacoco
    - Java코드의 커버리지를 체크하는 라이브러리
        결과를 html, xml, csv로 바로 확인 할 수 있다.
    - build.gradle 에 id 'jacoco' 추가

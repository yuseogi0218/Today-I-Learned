### 01. Swagger란?
- 개발한 REST API를 편리하게 문서화 해준다.
- 이를 통해서 관리 및 제 3의 사용자가 편리하게 API를 호출해보고 테스트 할 수 있는 프로젝트이다.

- Spring Boot에서는 간단하게 Annotation으로 적용시킬 수 있다.
- build.gradle에 springfox-boot-starter dependency 추가
    - Springframework_Boot 2.4.0 버전이랑 호환성이 맞음
    - 2.6.2 일시 , 다운 그레이드 필요!

- 다마느 주의할 점은 운영환경과 같은 외부에 노출되면 안되는 곳에는 사용할 땐 주의 해야 한다.

![image.png](attachment:image.png)

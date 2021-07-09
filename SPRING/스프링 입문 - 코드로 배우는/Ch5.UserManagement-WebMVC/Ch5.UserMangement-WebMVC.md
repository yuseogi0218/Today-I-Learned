## Ch5. 회원 관리 예제 - 웹 MVC 개발
- ### 회원 웹 기능 - 홈 화면 추가
    - HomeController 추가 및 home.html 파일 생성
    - HomeController에 @GetMappint("/") 추가 되어서 index.html 무시됨
        - home.html 먼저 실행

- ### 회원 웹 기능 - 등록
    - MemberController에 @GetMapping("/members/new") 추가 하고
        - 'members/createMemberForm' return 하여 createMemberForm.html 로 이동하게 함
    - 회원 등록 컨트롤
        - @PostMapping("/mapping/new") 추가
            - html에 form 태그에 method = "form"
                - 데이터 등록 시 자주 사용
            - form으로부터 getName 하여 memberService에 join 시킴
            - return "redirect:/";
                - home 화면 return
                
- ### 회원 웹 기능 - 조회
    -  타임리프 템플릿 기능
        - "${}" - 모델안의 값을 꺼내옴
        - th:each - for each 문과 동일
            - th:text = "${member.id}" - 값 꺼내옴
            
- ### 해당 데이터는 현재 메모리에 있기 때문에 
    - ### 서버를 내리면 데이터가 사라짐
    - ### → 데이터 베이스에 저장 필요

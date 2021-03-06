# 객체지향 설계 5원칙 SOLID
- ### 결합도는 낮추고 응집도는 높여야 한다.
    - 결합도
        - 클래스간의 상호 의존 정도를 나타내는 지표
        - 낮을 시 클래스간의 상호 의존성 감소
    - 응집도
        - 하나의 클래스 내부에 존재하는 구성 요소들의 기능적 관련성
        - 높을시, 하나의 책입에 집중하고 독립성이 높아짐
        
- ### **SRP** 
    - 단일 책임 원칙 - single responsibility principle
    - 한 클래스는 하나의 책임만 가져야 한다.
    - 책임의 중요한 기준은 변경이다. 
        - → 변경이 있을때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것
- ### **OCP**
    - 개방-폐쇄 원칙 - Open/clesed principle
    - 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
    - 코드의 변경없이 확장이 가능해야 한다. 
    - 다형성 활용
        - 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현
    - 구현 객체를 변경하려면 클라이언트 코드를 변경해야 한다. → OCP원칙이 안지켜짐
        - 객체 생성 및 연관관계를 맺어주는 별도의 조립, 설정자가 필요함 
            - → 스프링 컨테이너가 수행
- ### **LSP**
    - 리스코프 치환 원치 - Liskov substitution principle
    - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀수 있어야 한다.
    - 하위 클래스는 인터페이스 규약을 다 지켜야 한다는것. 
- ### **ISP**
    - 인터페이스 분리 원칙 - Interface segresgation principle
    - 특정 클라이언트를 위한 인터페이스 여러개가 범용 인터페이스 하나보다 낫다.
    - 각 기능에 맞게 인터페이스를 나누어야 함
- ### **DIP**
    - 의존관계 역전 원칙
    - 추상화에 의존해야지, 구체화에 의존하면 안된다.
    - 구현 클래스에 의존하지 말고, 인터페이스에 의존하라는 뜻
    - 클라이언트는 역할에 대해서만 알면 된다.
    - DIP 위반
        -  클라이언트는 인터페이스와 구현 클래스를 동시에 의존한다.
            
- ### 정리
    - 객체 지향의 핵심은 다형성
    - 다형성 만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없다.
    - 다형성 만으로는 구현 객체를 변경할 때 클라이언트 코드도 함께 변경됨
    - OCP, DIP 위반 → 뭔가 더 필요 → 

### Listener
- 특정 이벤트를 관찰하고 있다가, 해당 이벤트 발생 시 특정 동작 수행하는 것

### Entity Listener
- Entity 클래스에 추가
- 종류
    - @PrePersist : insert 문이 호출되기 전에 실행
    - @PreUpdate : merge 문이 호출되기 전에 실행
    - @PreRemove : delete 문이 호출되기 전에 실행
    - @PostPersist : insert 문이 호출된 후에 실행
    - @PostUpdate : merge 문이 호출된 후에 실행
    - @PostRemove : delete 문이 호출된 후에 실행
    - @PostLoad : select조회가 일어난 직후에 실행
- 활용
    - @PrePersis, @PreUpdate가 가장 많이 쓰임
    - Auditing - 감시
        - 해당 Entity가 언제 생성되었고, 수정되었는지 표시한다.
        - CreatedAt, UpdatedAt
        ``` java
        @PrePersist
        public void prePersist() {
            System.out.println(">>> PrePersist");
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }
        ```
    - @EntityListeners(value = Listener.class) 를 해당 Entity에 추가
        ``` java
        public class Listener {
            @PrePersist
            public void prePersist(Object o) {
                if (o instanceof Auditable) {
                    ((Auditable) o).setCreatedAt(LocalDateTime.now());
                    ((Auditable) o).setUpdatedAt(LocalDateTime.now());

                }
            }

            @PreUpdate
            public void preUpdate(Object o) {
                if (o instanceof Auditable) {
                    ((Auditable) o).setUpdatedAt(LocalDateTime.now());

                }
            }
        }
        ```
        
    - Auditable Interface
        ``` java
        public interface Auditable {
            LocalDateTime getCreatedAt();

            void setCreatedAt(LocalDateTime createdAt);

            LocalDateTime getUpdatedAt();

            void setUpdatedAt(LocalDateTime updatedAt);

        }
        ```
- EntityListener는 Spring bean을 주입받지 못한다.
    - Spring Bean 을 받아올 수 있는 support class 생성
    ``` java
    @Component
    public class BeanUtils implements ApplicationContextAware {
        private static ApplicationContext applicationContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            BeanUtils.applicationContext = applicationContext;
        }

        public static <T> T getBean(Class<T> clazz) {
            return applicationContext.getBean(clazz);
        }
    }
    ```

### Spring JPA 제공 기본 Listener
- Application Class에 @EnableJpaAuditing 추가
- Entity Class 에 @EntityListeners(value = AuditingEntityListener.class) 추가
- createdAt 변수에 @CreatedDate 추가
- updatedAt 변수에 @LastModifiedDate 추가


- LastModifiedBy, CreatedBy 
    - 수정 또는 생성 한 계정또한 추가 가능 - Spring Security 연계

### @MappedSuperClass
- 해당 annotation이 달린 클래스의 필드를 상속받는 Entity의 필드로 추가시켜 준다.


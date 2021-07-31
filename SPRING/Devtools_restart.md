## Spring Devtools restart로 자동 재시작하기

Spring Boot의 Devtools에는 classpath에 속해있는 파일들의 수정을 감지하고 자동으로 재시작해주는 기능이 포함되어 있다. 사용자가 만드는 클래스는 restart classloader로 읽어들이고, 이는 재시작이 완전히 껐다가 다시 키는 것보다 훨씬 빠르게 일어나도록 해준다.

재시작을 설정하는 방법은 두가지가 있다.
1. Spring Devtools의 디펜던시를 추가할 때 등록하는 방법
2. application.properties에서 설정하는 방법

### 디펜던시를 추가하면서 등록하기
**gradle**
``` java
developmentOnly 'org.springframework.boot:spring-boot-devtools'
```

### application.properties에서 설정하기
``` java
spring.devtools.restart.enabled = true
```

### IDE 설정 - Intellij
Intellij를 사용하는 경우, IDE 자체에서 추가설정을 해주어야 한다.
1. Intellij의 file->settings->build,execution,deployment->compiler에 있는 build project automatically를 체크해준다.
2. Intellij에서 SHIFT+CTRL+A를 누르고 registry를 입력한 뒤, compiler.automake.allow.when.app.running을 체크해준다.

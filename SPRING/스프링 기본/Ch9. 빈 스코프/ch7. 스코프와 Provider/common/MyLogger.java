package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request") // HTTP 요청 당 하나씩 생성된다.
public class MyLogger {

    private String uuid;
    private String requestURL;

    // requestURL 은 중간에 설정 가능하도록 설정
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "] " + "[" + requestURL + "] " + message);
    }

    // 클라이언트가 해당 HTTP 통신 최초로 호출시 실행 됨
    @PostConstruct
    public void init() {
        // 전 세계적으로 겹치지 않는 랜덤 ID 생성
        uuid = UUID.randomUUID().toString();

        System.out.println("[" + uuid + "] request scope bean create : " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close : " + this);
    }
}

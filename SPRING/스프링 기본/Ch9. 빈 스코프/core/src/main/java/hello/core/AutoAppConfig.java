package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 설정 정보
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //configuration 제외 (AppConfig.class 제외)
) // 컴포넌트 스캔 설정 -> 자동으로 (@Component) 빈을 읽어 등록함
public class AutoAppConfig {
}

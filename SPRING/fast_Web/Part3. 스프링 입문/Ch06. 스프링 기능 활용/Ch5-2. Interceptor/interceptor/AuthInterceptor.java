package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(url)
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url : {}", url);

        // 권한 확인
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation {}", hasAnnotation);

        // 나의 서버는 모두 Public 으로 동작을 하는데
        // 단, Auth 권한을 가진 요청에 대해서는 세션, 쿠키 등을 체크 한다.
        if (hasAnnotation) {
            // 권한 체크
            String query = uri.getQuery();
            log.info("query : {}", query);
            if (query.equals("name=steve")) {
                return true;
            }

            
        }
        return false;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {
        // resource javascript, html 은 그냥 통과
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            // Auth annotation 이 있을때는 true
            return true;
        }

        return false;
    }
}

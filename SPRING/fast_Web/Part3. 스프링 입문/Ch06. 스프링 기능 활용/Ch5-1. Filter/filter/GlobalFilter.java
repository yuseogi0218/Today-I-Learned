package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/user/*") // 특정 url 에 패턴 적용
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 들어가기 전 처리
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request); // bufferedReader 로 인해, 커서가 끝까지 가도, cache에 이미 저장이 되어 있으므로, 언제든지 다시 읽을 수 있다.
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        String url = httpServletRequest.getRequestURI(); // 요청 URL 확인


        chain.doFilter(request, response);

        // 후 처리
        // req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}", url, reqContent);

        // res
        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse(); // response body 에 내용을 한번 더 채워줌 -> 다 읽어서 커서가 마지막 까지 가있기 때문.

        log.info("response status : {}, responseBody : {}", httpStatus, resContent);
    }
}

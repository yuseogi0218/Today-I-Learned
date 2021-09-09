package com.example.websocketchat.handler;

import com.example.websocketchat.service.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class StompHandler implements ChannelInterceptor {

    private final JwtTokenProvider jwtTokenProvider;

    // Web socket 을 통해 들어온 요청이처리 되기 전 실행된다.
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        // web socket 연결 시 헤더의 jwt token 검증
        if (StompCommand.CONNECT == accessor.getCommand()) {
            jwtTokenProvider.validateToken(accessor.getFirstNativeHeader("token"));
        }
        return message;
    }
}

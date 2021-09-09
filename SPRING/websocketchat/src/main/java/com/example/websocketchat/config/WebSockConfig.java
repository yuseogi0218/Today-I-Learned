package com.example.websocketchat.config;

import com.example.websocketchat.handler.StompHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@RequiredArgsConstructor
@Configuration
@EnableWebSocketMessageBroker // stomp 사용을 위함
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {

    private final StompHandler stompHandler;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 메시지 구독 요청
        config.enableSimpleBroker("/sub");
        // 메시지 발행 요청
        config.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // stomp web socket 의 연결 endpoint 를 /ws-stomp 로 설정
        // ws://localhost:8080/ws-stomp
        registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("*").withSockJS();
    }

    // stompHandler 가 WebSocket 앞단에서 token 을 체크할 수 있도록 설정
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(stompHandler);
    }
}

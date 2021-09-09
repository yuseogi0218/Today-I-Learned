package com.example.websocketchat.repository;

import com.example.websocketchat.dto.ChatRoom;
import com.example.websocketchat.pubsub.RedisSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@RequiredArgsConstructor
@Repository
public class ChatRoomRepository {

    // Redis
    private static final String CHAT_ROOMS = "CHAT_ROOM";
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, ChatRoom> opsHashChatROOM;

    @PostConstruct
    private void init() {
        opsHashChatROOM = redisTemplate.opsForHash();
    }

    public List<ChatRoom> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        return opsHashChatROOM.values(CHAT_ROOMS);
    }

    // id 로 chatRoom 조회
    public ChatRoom findRoomById(String id) {
        return opsHashChatROOM.get(CHAT_ROOMS, id);
    }

    /**
     * 채팅방 생성 : 서버간 채팅방 공유를 위해 redis hash 에 저장
     */
    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        opsHashChatROOM.put(CHAT_ROOMS, chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }
}

package com.company.design.singleton;

public class SocketClient {

    // Singleton 패턴

    //
    private static SocketClient socketClient = null;

    // default 생성자를 private 로 선언 - 외부에서 접근 불가
    private SocketClient() {
    }

    // static getInstance() 로 자기 객체를 반환 시켜 준다.
    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}

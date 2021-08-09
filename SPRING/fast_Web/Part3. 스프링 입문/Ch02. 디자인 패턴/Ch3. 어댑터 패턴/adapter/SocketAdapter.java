package com.company.design.adapter;

import com.company.design.singleton.SocketClient;

// 220V 를 110V 로 변환시켜 줌
public class SocketAdapter implements Electronic110V {

    private Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }


    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}

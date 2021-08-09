package com.company.design;

import com.company.design.adapter.*;

public class Main {

    public static void main(String[] args) {

        Product110V product110V = new Product110V();
        connect(product110V);

        Product220V product220V = new Product220V();
        Electronic110V socketAdapter = new SocketAdapter(product220V); // 220V → 110V 변환기(어댑터)
        connect(socketAdapter);

        Product220V_2 product220V_2 = new Product220V_2();
        Electronic110V socketAdapter2 = new SocketAdapter(product220V_2); // 220V → 110V 변환기(어댑터)
        connect(socketAdapter2);
    }

    //콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();

    }
}

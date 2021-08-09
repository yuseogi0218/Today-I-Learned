package com.company.design.adapter;

public class Product220V_2 implements Electronic220V {

    @Override
    public void connect() {
        System.out.println("220V 전자 제품_2 on");
    }
}

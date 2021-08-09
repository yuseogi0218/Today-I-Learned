package com.company.design.adapter;

public class Product220V implements Electronic220V{

    @Override
    public void connect() {
        System.out.println("220V 전자 제품 on");
    }
}

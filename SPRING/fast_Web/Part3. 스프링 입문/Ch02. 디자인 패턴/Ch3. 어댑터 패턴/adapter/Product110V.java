package com.company.design.adapter;

public class Product110V implements Electronic110V {

    @Override
    public void powerOn() {
        System.out.println("110V 전자 제품 on");
    }
}

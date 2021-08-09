package com.company.design;

import com.company.design.aop.AopBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

        

        /**
         * AOP
         */

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    // runnable before
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    // runnable after
                    System.out.println("end");
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        // 초기 접근 - cache 미 활용
        aopBrowser.view();
        System.out.println("loading time : " + end.get());

        // cache 활용
        aopBrowser.view();
        System.out.println("loading time : " + end.get());
    }

}

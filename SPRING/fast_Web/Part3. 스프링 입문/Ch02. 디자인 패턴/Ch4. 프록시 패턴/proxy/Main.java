package com.company.design;

import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;

public class Main {

    public static void main(String[] args) {

        /**
         * Proxy
         */
        // Browser browser = new Browser("www.naver.com");
        // cache 안쓰고 호출
        //browser.view();

        // cache 사용하여 호출
        IBrowser browser = new BrowserProxy("www.naver.com");

        browser.view();
        browser.view();
        browser.view();
        browser.view();
        browser.view();

    }
}

package com.company.design.proxy;

public class Browser implements IBrowser{

    private String url;

    public Browser(String url) {
        this.url = url;
    }


    @Override
    public Html view() {
        System.out.println("browser loading html from : " + url);
        return new Html(url);
    }
}

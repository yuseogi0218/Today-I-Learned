package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        String result;

//        // Base64Encoder
//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        Encoder encoder = new Encoder(base64Encoder);
//        result = encoder.encode(url);
//        System.out.println(result);
//
//        // UrlEncoder
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
//        encoder.setIEncoder(urlEncoder);
//        result = encoder.encode(url);
//        System.out.println(result);

        Encoder encoder = context.getBean("base64Encode",Encoder.class);
        result = encoder.encode(url);
        System.out.println(result);

    }

}

@Configuration
class AppConfig {

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}

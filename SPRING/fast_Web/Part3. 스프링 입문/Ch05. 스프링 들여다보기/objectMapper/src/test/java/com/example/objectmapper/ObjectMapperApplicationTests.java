package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {

        System.out.println("-----------");

        // Text JSON -> Object
        // Object -> Text JSON

        // controller req json(text) -> Object
        // response Object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // object mapper 는 get method 를 활용한다. -> 즉 해당 object 에서 get 이 붙는 다른 method 를 생성하여서는 안된다.

        var user = new User("steve", 10, "010-1111-2222");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // object mapper 는 default 생성자를 필요로 한다.

        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);

    }

}

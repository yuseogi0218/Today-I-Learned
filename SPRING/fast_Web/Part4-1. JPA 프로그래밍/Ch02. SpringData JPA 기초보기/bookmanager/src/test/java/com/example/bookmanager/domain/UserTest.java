package com.example.bookmanager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {

    @Test
    void test() {
        User user = new User();
        user.setEmail("yuseogi0218@gmail.com");
        user.setName("yuseogi");

        System.out.println(">>> " + user);

    }
}
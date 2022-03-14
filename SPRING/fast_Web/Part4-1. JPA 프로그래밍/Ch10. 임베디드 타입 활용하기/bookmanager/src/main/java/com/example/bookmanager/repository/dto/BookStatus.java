package com.example.bookmanager.repository.dto;

import lombok.Data;

@Data
public class BookStatus {

    private int code;

    private String description;

    public boolean isDisplayed() {
        return code == 200;
    }

    public BookStatus(int code) {
        this.code = code;
        this.description = parseDescription(code);
    }

    private String parseDescription(int code) {
        switch (code) {
            case 100 :
                return "판매 종류";
            case 200 :
                return "판매 중";
            case 300 :
                return "판매 종료";
            default:
                return "default";
        }
    }
}

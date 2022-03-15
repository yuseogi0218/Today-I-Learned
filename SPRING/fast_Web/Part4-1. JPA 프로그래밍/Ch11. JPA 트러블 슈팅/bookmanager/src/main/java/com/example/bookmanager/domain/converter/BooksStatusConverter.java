package com.example.bookmanager.domain.converter;

import com.example.bookmanager.repository.dto.BookStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooksStatusConverter implements AttributeConverter<BookStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BookStatus status) {
        return status.getCode();
    }

    @Override
    public BookStatus convertToEntityAttribute(Integer code) {
        return code != null ? new BookStatus(code) : null;
    }
}

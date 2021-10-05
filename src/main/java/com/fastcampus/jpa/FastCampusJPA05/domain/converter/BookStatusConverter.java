package com.fastcampus.jpa.FastCampusJPA05.domain.converter;

import com.fastcampus.jpa.FastCampusJPA05.repository.dto.BookStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)//converter 표시
public class BookStatusConverter implements AttributeConverter<BookStatus,Integer> {//Entity의 Atribute,DataBase 컬럼 타입
    @Override
    public Integer convertToDatabaseColumn(BookStatus attribute) {
        return attribute.getCode();
        //return null;//code값을 반환 안할때
    }

    @Override
    public BookStatus convertToEntityAttribute(Integer dbData) {
        //Db에서 받아 BookStatus를 만들어준다.
        //Data가 Null이 올수도 있다.(오류가 안나도록 막아주어야된다.

        return dbData != null ? new BookStatus(dbData) : null;
    }
}

package com.fastcampus.jpa.FastCampusJPA05.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookNameAndCategory {
//public interface BookNameAndCategory {
    private String name;
    private String category;
    //String getCategory();
    //String getName();
}

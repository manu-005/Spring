package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Book {
    private int id;
    private String title;
    private String author;
    private int pages;
    private String genre;
    private int price;
    private String publication;
    private String language;
}

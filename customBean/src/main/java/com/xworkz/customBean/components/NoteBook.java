package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class NoteBook {
    private int id;
    private String brand;
    private int pages;
    private String color;
    private String size;
    private int price;
    private boolean hardCover;
    private String design;
}

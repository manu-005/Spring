package com.xworkz.zomato.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zomato")
public class RestaurantDTO {

    @Column(name = "rName")
    private String rName;

@Id
@Column(name = "rNo")
    private String rNo;

    @Column(name = "location")
    private String loc;

    @Column(name = "gstn")
    private String gstn;


    @Column(name = "openDate")
    private String openDate;

    @Column(name = "type")
    private String type;

    @Column(name = "landmark")
    private String    landmark;

    @Column(name = "email")
    private String email;

    @Column(name = "oNo")
    private long oNo;

    @Column(name = "oName")
    private String oName;

}

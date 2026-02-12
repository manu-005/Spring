package com.xworkz.xworkzModel.entity.responseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int responseId;

    @Column(name = "studentEmail", unique = true, nullable = false)
    private String studentEmail;
    private String response;

}

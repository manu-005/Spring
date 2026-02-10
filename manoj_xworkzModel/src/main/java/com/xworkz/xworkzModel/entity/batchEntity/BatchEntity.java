package com.xworkz.xworkzModel.entity.batchEntity;

import com.xworkz.xworkzModel.entity.fileentity.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int batchId;
    private String batchName;
    private String batchCode;
    private String trainerName;
    private String course;
    private LocalDate startDate;
    private LocalDate endDate;

    // BatchEntity
    @OneToOne
    @JoinColumn(name = "fileId")
    private FileEntity imageId;

}

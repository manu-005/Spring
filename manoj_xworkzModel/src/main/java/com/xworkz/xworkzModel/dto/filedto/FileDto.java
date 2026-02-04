package com.xworkz.xworkzModel.dto.filedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {

    private int fileId;
    private  int id;
    private MultipartFile profilePhoto;
}

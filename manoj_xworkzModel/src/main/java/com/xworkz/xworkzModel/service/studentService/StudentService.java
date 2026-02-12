package com.xworkz.xworkzModel.service.studentService;

import com.xworkz.xworkzModel.dto.responseDto.StudentResponseDTO;
import com.xworkz.xworkzModel.dto.studentDto.StudentDTO;
import com.xworkz.xworkzModel.entity.responseEntity.StudentResponseEntity;

import java.util.List;

public interface StudentService {
    boolean saveStudent(StudentDTO studentDTO,Integer batchId);

    List<StudentDTO> getAllStudentsByBatchId(Integer batchId);

    boolean saveResponse(StudentResponseDTO studentResponseDTO);

    List<StudentResponseDTO> checkResponseExists(String studentEmail);

    boolean updateResponse(StudentResponseDTO studentResponseDTO);
}

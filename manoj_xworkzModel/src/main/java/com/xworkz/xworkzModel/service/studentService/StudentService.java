package com.xworkz.xworkzModel.service.studentService;

import com.xworkz.xworkzModel.dto.responseDto.StudentResponseDTO;
import com.xworkz.xworkzModel.dto.studentDto.StudentDTO;

import java.util.List;

public interface StudentService {
    boolean saveStudent(StudentDTO studentDTO,Integer batchId);

    List<StudentDTO> getAllStudentsByBatchId(Integer batchId);

    boolean saveResponse(StudentResponseDTO studentResponseDTO);

    boolean checkResponseExists(String studentEmail);

    boolean updateResponse(StudentResponseDTO studentResponseDTO);
}

package com.xworkz.xworkzModel.service.studentService;

import com.xworkz.xworkzModel.dto.studentDto.StudentDTO;

public interface StudentService {
    boolean saveStudent(StudentDTO studentDTO,Integer batchId);
}

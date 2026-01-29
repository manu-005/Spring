package com.xworkz.xworkzModel.dao.studentdao;

import com.xworkz.xworkzModel.dto.studentDto.StudentDTO;
import com.xworkz.xworkzModel.dto.studentDto.StudentEntity;

public interface StudentDao {

    boolean saveStudent(StudentEntity entity );
}

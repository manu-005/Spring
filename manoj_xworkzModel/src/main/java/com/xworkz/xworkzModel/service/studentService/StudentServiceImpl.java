package com.xworkz.xworkzModel.service.studentService;

import com.xworkz.xworkzModel.dao.studentdao.StudentDao;
import com.xworkz.xworkzModel.dto.studentDto.StudentDTO;
import com.xworkz.xworkzModel.dto.studentDto.StudentEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public boolean saveStudent(StudentDTO studentDTO, Integer batchId) {
        StudentEntity entity = new StudentEntity();
        System.out.println("service saving student");

        BeanUtils.copyProperties(studentDTO, entity);
        entity.setBatchId(batchId);

        //dao
        studentDao.saveStudent(entity);
        return false;
    }
}

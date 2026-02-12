package com.xworkz.xworkzModel.service.studentService;

import com.xworkz.xworkzModel.dao.fileDao.FileDao;
import com.xworkz.xworkzModel.dao.studentdao.StudentDao;
import com.xworkz.xworkzModel.dto.batchdto.BatchDTO;
import com.xworkz.xworkzModel.dto.responseDto.StudentResponseDTO;
import com.xworkz.xworkzModel.dto.studentDto.StudentDTO;

import com.xworkz.xworkzModel.entity.batchEntity.BatchEntity;
import com.xworkz.xworkzModel.entity.fileentity.FileEntity;
import com.xworkz.xworkzModel.entity.responseEntity.StudentResponseEntity;
import com.xworkz.xworkzModel.entity.studentEntity.StudentEntity;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    FileDao fileDao;

    @SneakyThrows
    @Override
    public boolean saveStudent(StudentDTO studentDTO, Integer batchId) {

        System.out.println("service saving student");

        // 1️⃣ Handle Profile Image
        MultipartFile file = studentDTO.getProfileImage();

        String uploadDir = "D:\\projectUploadedImages\\";
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + fileName);

        Files.createDirectories(path.getParent());   // ensure folder exists
        byte[] bytes = file.getBytes();
        Files.write(path, bytes);

        System.out.println("file path: " + path);

        // 2️⃣ Save file info
        FileEntity fileEntity = new FileEntity();
        fileEntity.setOriginalFileName(file.getOriginalFilename());
        fileEntity.setFileDataBytes(bytes);               // optional (if storing in DB)
        fileEntity.setFileType(file.getContentType());
        fileEntity.setFilePath(path.toString());
        fileEntity.setFileSize(file.getSize());

        FileEntity savedFile = fileDao.save(fileEntity);

        // 3️⃣ Save student
        StudentEntity entity = new StudentEntity();
        BeanUtils.copyProperties(studentDTO, entity, "profileImage", "profileImagePath");

        entity.setBatchId(batchId);
        entity.setProfileImagePath(savedFile.getFilePath());   // store image path

//

        System.out.println("student saved successfully: " + entity);
        return studentDao.saveStudent(entity);
    }


    @Override
    public List<StudentDTO> getAllStudentsByBatchId(Integer batchId) {

        System.out.println("service started to get all students..");
        List<StudentEntity> entities = studentDao.getAllStudentsByBatchId(batchId);

        System.out.println("got students...");
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        List<StudentDTO> studentList = new ArrayList<>();

        for (StudentEntity entity : entities) {
            StudentDTO dto = new StudentDTO();

            BeanUtils.copyProperties(entity, dto);
            studentList.add(dto);
        }
        System.out.println("all students in service dto :" + studentList);
        return studentList;
    }

    @Override
    public boolean saveResponse(StudentResponseDTO studentResponseDTO) {
        System.out.println("service student dto  response :" + studentResponseDTO);
        if (studentResponseDTO != null) {
            StudentResponseEntity studentResponseEntity = new StudentResponseEntity();

            BeanUtils.copyProperties(studentResponseDTO, studentResponseEntity);

            System.out.println("after bean utils" + studentResponseEntity);

            boolean responseSaved = studentDao.saveResponse(studentResponseEntity);

            return responseSaved;
        } else return false;

    }

    @Override
    public StudentResponseDTO checkResponseExists(String studentEmail) {

        StudentResponseDTO studentResponseDTO =new StudentResponseDTO();
       StudentResponseEntity existEntity = studentDao.checkResponseExists(studentEmail);

       BeanUtils.copyProperties(existEntity,studentResponseDTO);
        return studentResponseDTO;
    }

    @Override
    public boolean updateResponse(StudentResponseDTO studentResponseDTO) {
        if (studentResponseDTO != null) {
            StudentResponseEntity studentResponseEntity = new StudentResponseEntity();

            BeanUtils.copyProperties(studentResponseDTO, studentResponseEntity);

            System.out.println("after bean utils in service update" + studentResponseEntity);

            return studentDao.updateResponse(studentResponseEntity);
        } else return false;

    }
}
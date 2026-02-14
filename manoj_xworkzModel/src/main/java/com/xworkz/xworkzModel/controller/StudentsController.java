package com.xworkz.xworkzModel.controller;

import com.google.protobuf.Message;
import com.xworkz.xworkzModel.dto.batchdto.BatchDTO;
import com.xworkz.xworkzModel.dto.responseDto.StudentResponseDTO;
import com.xworkz.xworkzModel.dto.responseDto.StudentResponseViewDTO;
import com.xworkz.xworkzModel.dto.studentDto.StudentDTO;
import com.xworkz.xworkzModel.entity.responseEntity.StudentResponseEntity;
import com.xworkz.xworkzModel.service.batchService.BatchService;
import com.xworkz.xworkzModel.service.studentService.StudentService;
import com.xworkz.xworkzModel.utility.EmailOTPSender;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentsController {
    private String studentName;

    public StudentsController() {
        System.out.println("student controller object created");
    }

    @Autowired
    StudentService studentService;

    @Autowired
    BatchService batchService;

    @Autowired
    EmailOTPSender messageSender;

    @GetMapping("addStudentButton")
    public ModelAndView addStudentButton(ModelAndView modelAndView, Integer batchId) {
        System.out.println("getting student form..");
        System.out.println(batchId + "batch id");

        modelAndView.addObject("batch", batchId);
        modelAndView.addObject("add", "Start adding here");
        modelAndView.setViewName("NewStudentAddForm");
        return modelAndView;
    }

    @PostMapping("saveNewStudent")
    public ModelAndView saveNewStudent(StudentDTO studentDTO, Integer batchId, ModelAndView modelAndView, BindingResult bindingResult) {

        System.out.println("Adding new students");
        System.out.println("profile" + studentDTO.getProfileImage());

        System.out.println("batch id :" + batchId);
        System.out.println("student dto :" + studentDTO);

        if (bindingResult.hasErrors()) {

            if (bindingResult.hasFieldErrors("name")) {

                modelAndView.addObject("nameError", bindingResult.getFieldError("name").getDefaultMessage());
                modelAndView.setViewName("NewStudentAddForm");
                return modelAndView;
            }

            if (bindingResult.hasFieldErrors("email")) {

                modelAndView.addObject("emailError", bindingResult.getFieldError("email").getDefaultMessage());
                modelAndView.setViewName("NewStudentAddForm");
                return modelAndView;
            }

            if (bindingResult.hasFieldErrors("mobile")) {

                modelAndView.addObject("mobileError", bindingResult.getFieldError("mobile").getDefaultMessage());
                modelAndView.setViewName("NewStudentAddForm");
                return modelAndView;
            }

            if (bindingResult.hasFieldErrors("gender")) {

                modelAndView.addObject("genderError", bindingResult.getFieldError("gender").getDefaultMessage());
                modelAndView.setViewName("NewStudentAddForm");
                return modelAndView;
            }

            if (bindingResult.hasFieldErrors("dob")) {

                modelAndView.addObject("dobError", bindingResult.getFieldError("dob").getDefaultMessage());
                modelAndView.setViewName("NewStudentAddForm");
                return modelAndView;
            }

            if (bindingResult.hasFieldErrors("courseMode")) {

                modelAndView.addObject("courseModeError", bindingResult.getFieldError("courseMode").getDefaultMessage());
                modelAndView.setViewName("NewStudentAddForm");
                return modelAndView;
            }
            if (bindingResult.hasFieldErrors("joiningDate")) {

                modelAndView.addObject("joiningDateError", bindingResult.getFieldError("joiningDate").getDefaultMessage());
                modelAndView.setViewName("NewStudentAddForm");
                return modelAndView;
            }
        } else {
            //saving student
            boolean saved = studentService.saveStudent(studentDTO, batchId);

//            boolean saved = true;

            if (saved) {
                modelAndView.addObject("batchId", batchId);
                modelAndView.addObject("success", "Student added successfully..");
            } else {
                modelAndView.addObject("error", "Can't able to add student, try again after sometimes..!");
            }
        }
        modelAndView.setViewName("AddNewStudent");
        return modelAndView;
    }

    @GetMapping("getAllStudentsInBatch")
    public ModelAndView viewBatchStudents(ModelAndView modelAndView, Integer batchId) {

        System.out.println("getting all students ..");
        System.out.println("batch id :" + batchId);

        BatchDTO batch = batchService.fetchById(batchId);
        List<StudentDTO> studentList = studentService.getAllStudentsByBatchId(batchId);

        System.out.println("all students in controller :" + studentList);

        modelAndView.addObject("batchId", batchId);
        modelAndView.addObject("batch", batch);
        modelAndView.addObject("student", studentList);
        modelAndView.setViewName("AllStudentList");
        return modelAndView;
    }

    @GetMapping("backToStudentList")
    public ModelAndView backToStudentList(ModelAndView modelAndView) {

        modelAndView.setViewName("AllStudentList");
        return modelAndView;
    }

    @SneakyThrows
    @GetMapping("viewStudentProfileImage")
    public void viewStudentProfileImage(HttpServletResponse response, @RequestParam("path") String path) {
        System.out.println("imagePath from student" + path);

        response.setContentType("image/jpg");
        File file = new File(path);
        InputStream inputStream = new BufferedInputStream((new FileInputStream(file)));
        ServletOutputStream servletOutputStream = response.getOutputStream();
        IOUtils.copy(inputStream, servletOutputStream);
        response.flushBuffer();

    }

    @GetMapping("sendMsgToAllStd")
    public ModelAndView sendMsgToAllStd(ModelAndView modelAndView, Integer batchId) {

        System.out.println("batch Id" + batchId);

        modelAndView.addObject("batchId", batchId);
        modelAndView.setViewName("SendMsgToStudents");
        return modelAndView;
    }

    @PostMapping("sendingMsgToAllStudents")
    public ModelAndView sendingMsgToAllStudents(ModelAndView modelAndView, String message, Integer batchId) {

        System.out.println("message:" + message);
        System.out.println("batch id to send message :" + batchId);

        List<StudentDTO> list = studentService.getAllStudentsByBatchId(batchId);
        System.out.println("student List: " + list);

        for (StudentDTO student : list) {
            String email = student.getEmail();   // get each student's email
            System.out.println(email + ",+message" + message);
            messageSender.sendMessageToAllStudents(email, message);  // send message
        }
        modelAndView.addObject("msg", "text for sample test");
        modelAndView.addObject("batchId", batchId);

        modelAndView.setViewName("SendMsgToStudents");
        return modelAndView;
    }

    @GetMapping("studentResponseForm")
    public ModelAndView showResponseForm(ModelAndView modelAndView, @RequestParam String studentEmail) {

        System.out.println("student response email" + studentEmail);
        modelAndView.addObject("email", studentEmail);

        modelAndView.setViewName("StudentResponseForm");

        return modelAndView;
    }

    @PostMapping("submitStudentResponse")
    public ModelAndView submitStudentResponse(StudentResponseDTO studentResponseDTO, ModelAndView modelAndView) {

        System.out.println("email :" + studentResponseDTO.getStudentEmail());
        System.out.println("mess :" + studentResponseDTO.getResponse());

        List<StudentResponseDTO> existDtoList = studentService.checkResponseExists(studentResponseDTO.getStudentEmail());

        if (existDtoList != null && !existDtoList.isEmpty()) {

            StudentResponseDTO existingDto = existDtoList.get(0);      // take first response only

            // update response text
            existingDto.setResponse(studentResponseDTO.getResponse());

            boolean updated = studentService.updateResponse(existingDto);
            if (updated) {
                modelAndView.addObject("msg", "Thank you! Your response is submitted.");
                modelAndView.addObject("email", studentResponseDTO.getStudentEmail());
            } else {
                modelAndView.addObject("errorMsg", "please try again after sometime...");
            }
        } else {
            //not exists -->save
            System.out.println(studentResponseDTO);
            boolean responseSaved = studentService.saveResponse(studentResponseDTO);

            if (responseSaved) {
                modelAndView.addObject("msg", "Thank you! Your response is submitted.");
                modelAndView.addObject("email", studentResponseDTO.getStudentEmail());
            } else {
                modelAndView.addObject("errorMsg", "please try again after sometime...");
            }
        }
        modelAndView.setViewName("StudentResponseSuccess");
        return modelAndView;
    }

    @GetMapping("viewAllStudentResponses")
    public ModelAndView viewAllStudentResponses(ModelAndView modelAndView, @RequestParam Integer batchId) {

        System.out.println("batch id in view response: " + batchId);

        List<StudentDTO> studentList = studentService.getAllStudentsByBatchId(batchId);
//        System.out.println("student list: " + studentList);

        List<StudentResponseViewDTO> responseViewList = new ArrayList<>();

        for (StudentDTO student : studentList) {

            String email = student.getEmail();

            List<StudentResponseDTO> studentResponseDTOs = studentService.checkResponseExists(email);

            StudentResponseViewDTO viewDTO = new StudentResponseViewDTO();
            viewDTO.setStudentName(student.getName());
            viewDTO.setEmail(email);

            if (studentResponseDTOs != null && !studentResponseDTOs.isEmpty()) {
                StudentResponseDTO existingDto = studentResponseDTOs.get(0); // take first
                viewDTO.setResponse(existingDto.getResponse());  // exists response
            } else {
                viewDTO.setResponse("No response");
            }

            responseViewList.add(viewDTO);
        }

            modelAndView.addObject("allResponses", responseViewList);
        modelAndView.setViewName("ViewAllStudentResponses");
        return modelAndView;
    }

}

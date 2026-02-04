package com.xworkz.xworkzModel.controller;

import com.xworkz.xworkzModel.dto.UserDto;
import com.xworkz.xworkzModel.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JsController {

    public JsController(){
        System.out.println("js controller object created");
    }
    @Autowired
    ModelService service;

    @GetMapping("fetchUserByEmailId")
    public String fetchUserByEmailId(String email) {
        UserDto dto = service.findByEmail(email);

        if (dto == null) {
            return "e-mail id is not exist..";
        } else {
            return "valid..";
        }
    }
}

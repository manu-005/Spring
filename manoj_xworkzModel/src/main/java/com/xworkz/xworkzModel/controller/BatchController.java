package com.xworkz.xworkzModel.controller;

import com.xworkz.xworkzModel.dto.batchdto.BatchDTO;
import com.xworkz.xworkzModel.service.batchService.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class BatchController {

    public BatchController(){
        System.out.println("Batch controller object");
    }

    @Autowired
    BatchService batchService;

    @GetMapping("addNewBatch")
    public ModelAndView addNewBatch(ModelAndView modelAndView){

        modelAndView.setViewName("NewBatchForm");
        return modelAndView;
    }

    @PostMapping("newBatchForm")
    public ModelAndView newBatchForm(ModelAndView modelAndView,BatchDTO dto){

        System.out.println("adding new batch");

        System.out.println(dto);
        batchService.addNewBatch(dto);
        modelAndView.setViewName("NewBatchForm");
        return modelAndView;
    }



}

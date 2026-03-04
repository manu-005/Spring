package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.dto.organizer.DelegatesEmailDTO;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ConferenceHosterController {

    @Autowired
    ConferenceHosterService conferenceHosterService;

    public ConferenceHosterController() {
        System.out.println("conference hoster controller object created ..");
    }

    @GetMapping("index")
    public ModelAndView loadIndex(ModelAndView model) {

        System.out.println("index  loading in controller :........");
        List<ConferenceHosterDTO> list =
                conferenceHosterService.getAllConferenceHoster();

        model.addObject("dtoList", list);
        System.out.println(list);
        model.setViewName("index");
        return model;   // index.jsp
    }

    @PostMapping("organizerDetails")
    public ModelAndView saveOrganizerDetails(
            @Valid ConferenceHosterDTO organizerDTO,
            BindingResult bindingResult, String tpoEmails) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

//      List<ConferenceHosterDTO> allOrganizeHoster =  conferenceHosterService.getAllConferenceHoster();
//
//      for(ConferenceHosterDTO dto : allOrganizeHoster) {
//          System.out.println("all  hosters :" + dto);
//      }

//      modelAndView.addObject("allDTOList",allOrganizeHoster);

        MultipartFile banner = organizerDTO.getConferenceBanner();
        MultipartFile promoVideo = organizerDTO.getPromoVideo();

        System.out.println("dto :" + organizerDTO);
        System.out.println("checking validation..");

        // Check validation errors
        if (bindingResult.hasErrors() || banner == null || banner.isEmpty()) {

            System.out.println("entered has errors");
            // Banner validation
            if (banner == null || banner.isEmpty()) {
                modelAndView.addObject("conferenceBannerError", "Please upload conference banner");
            }

            // Promo video validation (optional – remove if not mandatory)
            if (promoVideo == null || promoVideo.isEmpty()) {
                modelAndView.addObject("promoVideoError", "Please upload promo video");
            }
            // Field errors automatically
            bindingResult.getFieldErrors().forEach(error -> {
                String field = error.getField();
                String message = error.getDefaultMessage();

                System.out.println(field + "  :error:  message :" + message);

                modelAndView.addObject(field + "Error", message);
            });

            return modelAndView;
        }
        // If no errors → Save data

        ConferenceHosterDTO savedConferenceHosterDTO = conferenceHosterService.validAndSave(organizerDTO);
        System.out.println("saving");

        if (savedConferenceHosterDTO != null) {
            String[] emailArray = tpoEmails.split(",");

            boolean delegateSaved = conferenceHosterService.saveDelegatesEmail(emailArray, savedConferenceHosterDTO);

            System.out.println("saved delegates in controller :" + delegateSaved);
            modelAndView.addObject("successMsg", "Your Conference Successfully Registered");
        } else {
            modelAndView.addObject("errorMsg", "Conference registration failed. Please try again.");
        }
        return modelAndView;
    }

    @SneakyThrows
    @GetMapping("fetchBanner")
    public void fetchBanner(HttpServletResponse response,  ModelAndView modelAndView) {

        System.out.println("entered in fetch banner");

        List<ConferenceHosterDTO> allHosterDTO = conferenceHosterService.getAllConferenceHoster();

        modelAndView.setViewName("index");
        modelAndView.addObject("dtoList", allHosterDTO);
        System.out.println("all dtos :" + allHosterDTO);

        for (ConferenceHosterDTO dto : allHosterDTO) {
            String bannerPath = dto.getBannerPath();

            System.out.println("delegates email in service :" + dto.getDelegateEmails());
            System.out.println("all iin fetch images banner path :" + dto.getBannerPath());

            response.setContentType("image/jpeg");
            File file = new File(bannerPath);
            InputStream inputStream = new BufferedInputStream((new FileInputStream(file)));
            ServletOutputStream servletOutputStream = response.getOutputStream();
            IOUtils.copy(inputStream, servletOutputStream);
            response.flushBuffer();
        }
    }
    //    @RequestMapping(apic)
    //    full data retuen
    @GetMapping("fetchAllConference")
    public String fetchAllConference(){

        return "hello";
    }
}

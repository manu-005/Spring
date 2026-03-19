package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.dto.organizer.DelegatesEmailDTO;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class ConferenceHosterController {

    @Autowired
    ConferenceHosterService conferenceHosterService;

    public ConferenceHosterController() {
        System.out.println("conference hoster controller object created ..");
    }
    @GetMapping("/")
    public ModelAndView loadIndex() {

        ModelAndView mv = new ModelAndView("index");

        List<ConferenceHosterDTO> all =
                conferenceHosterService.getAllConferenceHoster();

        List<ConferenceHosterDTO> futureEvents = new ArrayList<>();

        for (ConferenceHosterDTO dto : all) {
            if (dto.getDate().isAfter(LocalDate.now())) {
                futureEvents.add(dto);
            }
        }

        mv.addObject("events", futureEvents);

        return mv;
    }

    @PostMapping("organizerDetails")
    public ModelAndView saveOrganizerDetails(
            @Valid ConferenceHosterDTO organizerDTO,
            BindingResult bindingResult,ModelAndView modelAndView) {

        modelAndView.setViewName("index");

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
                modelAndView.addObject("errorMsg", "Conference registration failed. Please try again.");

            });

            return modelAndView;
        }
        // If no errors → Save data

//        ConferenceHosterDTO savedConferenceHosterDTO = conferenceHosterService.validAndSave(organizerDTO);
        System.out.println("saving");

//        if (savedConferenceHosterDTO != null) {
            if(true){
            String[] emailArray = organizerDTO.getTpoEmails().split(",");
            System.out.println("email array :"+ Arrays.toString(emailArray));
//            boolean delegateSaved = conferenceHosterService.saveDelegatesEmail(emailArray, savedConferenceHosterDTO);

//            System.out.println("saved delegates in controller :" + delegateSaved);
            modelAndView.addObject("successMsg", "Your Conference Successfully Registered");
        } else {
            modelAndView.addObject("errorMsg", "Conference registration failed. Please try again.");
        }
        return modelAndView;
    }

    @SneakyThrows
    @GetMapping("fetchBanner")
    public void fetchBanner(HttpServletResponse response, ModelAndView modelAndView, @RequestParam("conferenceId") int conferenceId) {

        System.out.println("conference id :" + conferenceId);

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
    //    full data return

//    @GetMapping("fetchAllConference")
//    public String fetchAllConference(ModelAndView modelAndView, Model model,HttpSession session) {
//        System.out.println("fetch conference called..");
//        List<ConferenceHosterDTO> allHosterDTO = conferenceHosterService.getAllConferenceHoster();
//
//        LocalDate currentDate = LocalDate.now();
//        List<ConferenceHosterDTO> futureEvents = new ArrayList<>();
//
//        for (ConferenceHosterDTO dto : allHosterDTO) {
//            if (dto.getDate().isAfter(currentDate)) {
//                futureEvents.add(dto);
//            }
//        }
//
//        modelAndView.addObject("events", futureEvents);
//        modelAndView.setViewName("index");
//        System.out.println("Future events: " + futureEvents);
//
//        session.setAttribute("events",futureEvents);
//        model.addAttribute("events",futureEvents);
//        return "index";
//    }

//    @GetMapping("")
//    public ModelAndView loadIndex() {
//
//        System.out.println("entered in load index");
//        ModelAndView mv = new ModelAndView("index");
//
//        List<ConferenceHosterDTO> all = conferenceHosterService.getAllConferenceHoster();
//
//        // filter future events
//        List<ConferenceHosterDTO> futureEvents = new ArrayList<>();
//
//        for (ConferenceHosterDTO dto : all) {
//            if (dto.getDate().isAfter(LocalDate.now())) {
//                futureEvents.add(dto);
//            }
//        }
//
//        mv.addObject("events", futureEvents);
//
//        System.out.println("Events: " + futureEvents);
//
//        return mv;
//    }
}

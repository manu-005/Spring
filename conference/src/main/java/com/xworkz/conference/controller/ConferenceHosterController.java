package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ConferenceHosterController {

    @Autowired
    ConferenceHosterService conferenceHosterService;

    public ConferenceHosterController() {
        System.out.println("conference hoster controller object created ..");
    }

    @PostMapping("organizerDetails")
    public ModelAndView saveOrganizerDetails(
            @Valid ConferenceHosterDTO organizerDTO,
            BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

      List<ConferenceHosterDTO> allOrganizeHoster =  conferenceHosterService.getAllConferenceHoster();

      for(ConferenceHosterDTO dto : allOrganizeHoster) {
          System.out.println("all  hosters :" + dto);
      }

      modelAndView.addObject("allDTOList",allOrganizeHoster);


        MultipartFile banner = organizerDTO.getConferenceBanner();
        MultipartFile promoVideo = organizerDTO.getPromoVideo();

        System.out.println("dto :"+organizerDTO);
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

                System.out.println(field+"  :error:  message :"+message);

                modelAndView.addObject(field + "Error", message);
            });

            return modelAndView;
        }

        // If no errors → Save data
        boolean saved = conferenceHosterService.validAndSave(organizerDTO);
        System.out.println("saving");

        if (saved) {
            modelAndView.addObject("successMsg", "Your Conference Successfully Registered");
        } else {
            modelAndView.addObject("errorMsg", "Conference registration failed. Please try again.");
        }

        return modelAndView;
    }

    @GetMapping("fetchBanner")
    public void fetchBanner(){

        System.out.println("entered in fetch banner");

      List<ConferenceHosterDTO> allHosterDTO =  conferenceHosterService.getAllConferenceHoster();

        for(ConferenceHosterDTO dto : allHosterDTO) {
            System.out.println("all iin fetch images hosters :" + dto);
        }
    }
}

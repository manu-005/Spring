package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.dto.organizer.DelegatesEmailDTO;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.entity.delegatesEmailEntity.DelegatesEmailEntity;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;

@RequestMapping("/")
@Controller
public class AdminController {

    @Autowired
    ConferenceHosterService conferenceHosterService;

    @GetMapping("adminLoginForm")
    public ModelAndView adminLoginForm(ModelAndView modelAndView) {
        modelAndView.setViewName("AdminLoginForm");
        return modelAndView;
    }

    @PostMapping("adminLogin")
    public ModelAndView adminLogin(ModelAndView modelAndView, String email, String password) {

        System.out.println("email :" + email);
        System.out.println("password :" + password);
        modelAndView.setViewName("AdminDashBoard");
        return modelAndView;
    }

    @GetMapping("getAllHosters")
    public ModelAndView getAllHosters(ModelAndView modelAndView) {

        System.out.println("getting all hoster in admin");
        List<ConferenceHosterDTO> allHosters = conferenceHosterService.getAllConferenceHoster();

        modelAndView.addObject("hosters", allHosters);

        for (ConferenceHosterDTO hoster : allHosters) {
            System.out.println("Conference Title in controller : " + hoster.getConferenceTitle());
            System.out.println("Delegates: " + hoster.getDelegates());

        }
        System.out.println("all hosters :" + allHosters);
        modelAndView.setViewName("AllHosters");

        return modelAndView;
    }

    @GetMapping("getAllDelegates")
    public ModelAndView getAllDelegates(ModelAndView modelAndView) {
        System.out.println("entered  in All delegates");
        modelAndView.setViewName("AllDelegates");
        return modelAndView;
    }

    @GetMapping("filterDelegates")
    public ModelAndView filterDelegates(ModelAndView modelAndView, String type) {

        List<DelegatesEmailDTO> allDelegates = conferenceHosterService.getAllDelegates();

        List<DelegatesEmailDTO> sameDelegates = new ArrayList<>();
        Set<String> emailList = new HashSet<>();

        System.out.println("all delegates in controller :" + allDelegates);

        for (DelegatesEmailDTO dto : allDelegates) {

            if (type != null && type.equals(dto.getTargetDelegates())) {

                String[] emailArray = dto.getDelegatesEmail().split(",");

                System.out.println("all emails after split :" + Arrays.toString(emailArray));

                for (String email : emailArray) {
                    emailList.add(email.trim());
                }

                sameDelegates.add(dto);
            }
        }

        System.out.println("after split email ids :" + emailList);

        modelAndView.addObject("sameDelegatesList", sameDelegates);
        modelAndView.addObject("emailList", emailList);

        modelAndView.setViewName("AllDelegates");

        return modelAndView;
    }

    @GetMapping("getAllEvents")
    public ModelAndView getAllEvents(ModelAndView modelAndView) {

        List<ConferenceHosterDTO> allEvents = conferenceHosterService.getAllConferenceHoster();

        for (ConferenceHosterDTO dtp : allEvents) {

        }
        modelAndView.addObject("allEvents", allEvents);
        modelAndView.setViewName("AllEventsDetails");

        return modelAndView;
    }

    @GetMapping("fetchBannerImage")
    public void fetchBannerImage(HttpServletResponse response, String bannerPath) {

        try {
            System.out.println("Banner path: " + bannerPath);

            File file = new File(bannerPath);

            if (!file.exists()) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            String contentType = Files.probeContentType(file.toPath());
            response.setContentType(contentType);

            try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
                 ServletOutputStream outputStream = response.getOutputStream()) {

                IOUtils.copy(inputStream, outputStream);
                outputStream.flush();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @GetMapping("fetchBannerImages")
    public void fetchBannerImages(HttpServletResponse response, @RequestParam("conferenceId") Long conferenceId) {

        System.out.println("===========================================================================");
        System.out.println("conference  id inn admin :" + conferenceId);

        ConferenceHosterDTO dto = conferenceHosterService.getAllConferenceHosterById(conferenceId);

        System.out.println("banner path in fetch image :" + dto.getBannerPath());
        String urlPath = dto.getBannerPath().replace("\\", "/");

        System.out.println("url path :" + urlPath);
        response.setContentType("image/jpg");
        File file = new File(urlPath);
        InputStream inputStream = new BufferedInputStream((new FileInputStream(file)));
        ServletOutputStream servletOutputStream = response.getOutputStream();
        IOUtils.copy(inputStream, servletOutputStream);
        response.flushBuffer();
    }

    @SneakyThrows
    @GetMapping("fetchPromoVideo")
    public void fetchPromoVideo(HttpServletResponse response, @RequestParam("conferenceId") Long conferenceId) {

        System.out.println("enterd in promo video and conference id is :"+conferenceId);

        ConferenceHosterDTO dto = conferenceHosterService.getAllConferenceHosterById(conferenceId);

        System.out.println("banner path in fetch image :" + dto.getPromoVideoPath());
        String urlPath = dto.getPromoVideoPath().replace("\\", "/");

        System.out.println("url path :" + urlPath);
        response.setContentType("video/mp4");
        File file = new File(urlPath);
        InputStream inputStream = new BufferedInputStream((new FileInputStream(file)));
        ServletOutputStream servletOutputStream = response.getOutputStream();
        IOUtils.copy(inputStream, servletOutputStream);
        response.flushBuffer();
    }

    @GetMapping("sendConference")
    public ModelAndView sendConference(@RequestParam("conferenceId") Long conferenceId,ModelAndView modelAndView) {

        System.out.println("Conference ID received: " + conferenceId);

        ConferenceHosterDTO dto = conferenceHosterService.getAllConferenceHosterById(conferenceId);

        modelAndView.addObject("conference", dto);
        System.out.println("delegates ====================:"+ dto.getDelegates());

        List<String> emailList = new ArrayList<>();
        for (DelegatesEmailEntity email :dto.getDelegates()){

            System.out.println("email of delegates :"+ email.getDelegatesEmail());
            String[] emailArray = email.getDelegatesEmail().split(",");
            System.out.println("email array in delegates :"+ Arrays.toString(emailArray));

            emailList.addAll(Arrays.asList(emailArray));

        }
        System.out.println("email list ====:"+emailList);

        System.out.println("delegates email :"+dto.getDelegateEmails());
        modelAndView.addObject("emailList", emailList);

        modelAndView.setViewName("ConferenceDetails"); // JSP page name

        return modelAndView;
    }

    @PostMapping("shareConference")
    public ModelAndView shareConference(Long conferenceId,String emails,ModelAndView modelAndView){

        System.out.println("conference id in share event : "+conferenceId);

        System.out.println("emails in share event : "+emails);
        return modelAndView;
    }
}
package com.xworkz.conference.controller;

import com.xworkz.conference.dto.admin.AdminDTO;
import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.dto.organizer.DelegatesEmailDTO;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.entity.delegatesEmailEntity.DelegatesEmailEntity;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import com.xworkz.conference.utility.DelegatesMailSending;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @Autowired
    DelegatesMailSending delegatesMailSending;

    @GetMapping("adminLoginForm")
    public ModelAndView adminLoginForm(ModelAndView modelAndView) {
        modelAndView.setViewName("AdminLoginForm");
        return modelAndView;
    }

    @PostMapping("adminLogin")
    public ModelAndView adminLogin(ModelAndView modelAndView, AdminDTO adminDTO) {

        System.out.println("email :" + adminDTO.getUserName());
        System.out.println("password :" + adminDTO.getPassword());

        boolean verify = conferenceHosterService.varifyAdmin(adminDTO);
        if (verify) {

            List<ConferenceHosterDTO> allEvents = conferenceHosterService.getAllConferenceHoster();

            modelAndView.addObject("allEvents", allEvents);
            modelAndView.setViewName("AllEventsDetails");

            modelAndView.setViewName("AdminDashBoard");

        } else {
            modelAndView.addObject("error", "Invallid credential");
            modelAndView.setViewName("AdminLoginForm");
        }
        return modelAndView;
    }

    @GetMapping("getAllEvents")
    public ModelAndView getAllEvents(ModelAndView modelAndView) {

        List<ConferenceHosterDTO> allEvents = conferenceHosterService.getAllConferenceHoster();

        modelAndView.addObject("allEvents", allEvents);
        modelAndView.setViewName("AdminDashBoard");

        return modelAndView;
    }

    @GetMapping("getNewEvents")
    public ModelAndView getNewEvents(ModelAndView modelAndView) {

        List<ConferenceHosterDTO> allEvents = conferenceHosterService.getAllConferenceHoster();

        List<ConferenceHosterDTO> newEvents = new ArrayList<>();
        for (ConferenceHosterDTO dto : allEvents) {

            System.out.println("status of accepting:" + dto.isAcceptOrDecline());
            if (!dto.isAcceptOrDecline()) {
                newEvents.add(dto);
            }
        }
        modelAndView.addObject("newEvents", newEvents);
        modelAndView.setViewName("AllNewEvents");
        return modelAndView;
    }

    @GetMapping("acceptEvent")
    public ModelAndView acceptEvent(Long conferenceId, ModelAndView modelAndView) {

        boolean updateAccept = true;
        boolean accepted = conferenceHosterService.updateAcceptOrDecline(conferenceId, updateAccept);

        if (accepted) {
            modelAndView.addObject("acceptMessage", "Event accepted..!");
        }else{
            modelAndView.addObject("errorMessage", "Try again after sometimes..!");
        }
        modelAndView.setViewName("AllNewEvents");
        return modelAndView;
    }

    @GetMapping("declineEvent")
    public ModelAndView declineEvent(Long conferenceId, ModelAndView modelAndView) {

        boolean updateAccept = false;
        boolean declined = conferenceHosterService.updateAcceptOrDecline(conferenceId, updateAccept);

        if (declined) {
            modelAndView.addObject("declineMessage", "Event declined..!");
        }else{
            modelAndView.addObject("errorMessage", "Try again after sometimes..!");
        }

        List<ConferenceHosterDTO> allEvents = conferenceHosterService.getAllConferenceHoster();

        List<ConferenceHosterDTO> newEvents = new ArrayList<>();
        for (ConferenceHosterDTO dto : allEvents) {

            System.out.println("status of accepting:" + dto.isAcceptOrDecline());
            if (!dto.isAcceptOrDecline()) {
                newEvents.add(dto);
            }
        }
        modelAndView.addObject("newEvents", newEvents);

        modelAndView.setViewName("AllNewEvents");

        return modelAndView;
    }

    @GetMapping("acceptedEvents")
    public ModelAndView acceptedEvents(ModelAndView modelAndView){

        List<ConferenceHosterDTO> allEvents = conferenceHosterService.getAllConferenceHoster();

        List<ConferenceHosterDTO> acceptedEvents = new ArrayList<>();
        for (ConferenceHosterDTO dto : allEvents) {

            System.out.println("status of accepting:" + dto.isAcceptOrDecline());
            if (dto.isAcceptOrDecline()) {
                acceptedEvents.add(dto);
                System.out.println("accepted events :"+dto);
            }
        }
        modelAndView.addObject("acceptedEvents", acceptedEvents);

        modelAndView.setViewName("AcceptedEvents");
        return modelAndView;
    }

    @GetMapping("invitedEvents")
    public ModelAndView invitedEvents(ModelAndView modelAndView){

        List<ConferenceHosterDTO> allEvents = conferenceHosterService.getAllConferenceHoster();

        List<ConferenceHosterDTO> invitedEvents = new ArrayList<>();
        for (ConferenceHosterDTO invitedDto : allEvents) {

            System.out.println("status of accepting:" + invitedDto.isSentToDelegates());
            if (invitedDto.isSentToDelegates()) {
                invitedEvents.add(invitedDto);
                System.out.println("accepted events :"+invitedDto);
            }
        }
        modelAndView.addObject("invitedEvents", invitedEvents);

        modelAndView.setViewName("InvitedEvents");
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

        List<DelegatesEmailDTO> allDelegates = conferenceHosterService.getAllDelegates();

        List<DelegatesEmailDTO> sameDelegates = new ArrayList<>();
        Set<String> emailList = new HashSet<>();

        System.out.println("all delegates in controller :" + allDelegates);

        for (DelegatesEmailDTO dto : allDelegates) {

            if (true) {

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

    @PostMapping("tpoDetailsInAdmin")
    public ModelAndView tpoDetailsInAdmin(ModelAndView modelAndView, String email, HttpSession session){

        List<DelegatesEmailDTO> allDelegates = conferenceHosterService.getAllDelegates();

        List<ConferenceHosterDTO> tpoDTOList = new ArrayList<>();
        List<Long> conferenceIdList = new ArrayList<>();

        for (DelegatesEmailDTO dto : allDelegates) {

            if (dto.getDelegatesEmail() != null && !dto.getDelegatesEmail().isEmpty()) {

                String[] emailArray = dto.getDelegatesEmail().split(",");

//                System.out.println("Split Emails: " + Arrays.toString(emailArray));

                for (String e : emailArray) {

                    if (email.trim().equalsIgnoreCase(e.trim())) {

                        Long conferenceId = dto.getConferenceHoster().getConferenceId();

                        // avoid duplicate conference ids
                        if (!conferenceIdList.contains(conferenceId)) {

                            conferenceIdList.add(conferenceId);

                            ConferenceHosterDTO conferenceDTO =
                                    conferenceHosterService.getAllConferenceHosterById(conferenceId);

                            if (conferenceDTO != null) {
                                tpoDTOList.add(conferenceDTO);
                            }
                        }
                        break;
                    }
                }
            }
        }

        System.out.println("Matched Conference IDs: " + conferenceIdList);

        modelAndView.addObject("tpoDTOList", tpoDTOList);
//        modelAndView.addObject("conferenceIdList", conferenceIdList);
        modelAndView.addObject("email", email);

        session.setAttribute("topEmail",email);

        modelAndView.setViewName("TPODetailsInAdmin");
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

        System.out.println("enterd in promo video and conference id is :" + conferenceId);

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
    public ModelAndView sendConference(@RequestParam("conferenceId") Long conferenceId, ModelAndView modelAndView) {

        System.out.println("Conference ID received: " + conferenceId);

        ConferenceHosterDTO dto = conferenceHosterService.getAllConferenceHosterById(conferenceId);

        modelAndView.addObject("conference", dto);
        System.out.println("delegates ====================:" + dto.getDelegates());

        List<String> emailList = new ArrayList<>();

        for (DelegatesEmailEntity email : dto.getDelegates()) {

            String[] emailArray = email.getDelegatesEmail().split(",");

            System.out.println("email array in delegates ::...:" + Arrays.toString(emailArray));

            emailList.addAll(Arrays.asList(emailArray));
        }
        System.out.println("email list ====:" + emailList);

        modelAndView.addObject("emailList", emailList);
        modelAndView.setViewName("ConferenceDetails"); // JSP page name

        return modelAndView;
    }

    @GetMapping("viewDelegates")
    public ModelAndView viewDelegates(ModelAndView modelAndView, Long conferenceId) {
        System.out.println("Conference ID received: " + conferenceId);

        ConferenceHosterDTO dto = conferenceHosterService.getAllConferenceHosterById(conferenceId);

        modelAndView.addObject("conference", dto);
        System.out.println("delegates ====================:" + dto.getDelegates());

        List<String> emailList = new ArrayList<>();

        for (DelegatesEmailEntity email : dto.getDelegates()) {

            String[] emailArray = email.getDelegatesEmail().split(",");

            System.out.println("email array in delegates ::...:" + Arrays.toString(emailArray));

            emailList.addAll(Arrays.asList(emailArray));
        }
        System.out.println("email list ====:" + emailList);

        modelAndView.addObject("emailList", emailList);
        modelAndView.setViewName("AllDelegates"); // JSP page name

        return modelAndView;
    }

    @GetMapping("logOut")
    public ModelAndView logOut(ModelAndView modelAndView){

        System.out.println("log out");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
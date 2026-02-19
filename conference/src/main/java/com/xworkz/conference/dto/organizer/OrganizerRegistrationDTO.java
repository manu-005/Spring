package com.xworkz.conference.dto.organizer;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrganizerRegistrationDTO {

    private String fullName;

    private String officialEmail;

    private String organizationName;

    private String conferenceTitle;

    private String conferenceDescription;

    private LocalDate date;

    private LocalTime time;

    private String mode; // Online / Offline / Hybrid

    private String venueOrMeetingLink;

    private MultipartFile conferenceBanner;

    private MultipartFile promoVideo;

}
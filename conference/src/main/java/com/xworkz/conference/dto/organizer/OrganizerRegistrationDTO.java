package com.xworkz.conference.dto.organizer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerRegistrationDTO {

    private String fullName;

    private String officialEmail;

    private String organizationName;

    private String conferenceTitle;

    private String conferenceDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;


    private String mode; // Online / Offline / Hybrid

    private String venueOrMeetingLink;

    private MultipartFile conferenceBanner;

    private MultipartFile promoVideo;

}
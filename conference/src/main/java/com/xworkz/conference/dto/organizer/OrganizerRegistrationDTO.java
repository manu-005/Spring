package com.xworkz.conference.dto.organizer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerRegistrationDTO {

//    @NotBlank(message = "please enter your full name")
    @NotNull
    @Size(min = 2, max = 10, message = "Full Name size must be between 2 and 10")
    private String fullName;

    @Email(message = "invalid formate")
    private String officialEmail;

    @NotBlank(message = "please enter your organization")
    private String organizationName;

    @NotBlank(message = "please enter your conference title")
    private String conferenceTitle;

    @NotBlank(message = "please enter conference description")
    private String conferenceDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

    @NotBlank(message = "please select your conference mode")
    private String mode; // Online / Offline / Hybrid

    @NotBlank(message = "please mention venue or link")
    private String venueOrMeetingLink;

    @NotNull(message = "please select conference banner")
    private MultipartFile conferenceBanner;

    @NotNull(message = "please select conference promo video")
    private MultipartFile promoVideo;

}
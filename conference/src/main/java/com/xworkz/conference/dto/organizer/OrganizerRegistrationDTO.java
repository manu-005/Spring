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

    @NotBlank(message = "Please enter your full name")
    @Size(min = 4, max = 20, message = "Full Name size must be between 4 and 20")
    private String fullName;

    @Email(message = "invalid formate")
    @NotBlank(message = "please enter your official email")
    private String officialEmail;

    @NotBlank(message = "please enter your organization name")
    @Size(min = 4, max = 50, message = "Organization Name size must be between 4 and 50")
    private String organizationName;

    @NotBlank(message = "please enter your conference title")
    @Size(min = 4, max = 50, message = "conference title size must be between 4 and 50")
    private String conferenceTitle;

    @NotBlank(message = "please enter conference description")
    @Size(min = 4, max = 500, message = "conference description size must be between 4 and 500")
    private String conferenceDescription;

    @NotNull(message = "please select valid date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "please select time")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

    @NotBlank(message = "please select your conference mode")
    @Size(min = 4, max = 100, message = "select conference mode ")
    private String mode; // Online / Offline / Hybrid

    @NotBlank(message = "please mention venue or link")
    @Size(min = 4, max = 500, message = "conference meeting or venue size must be between 4 and 500")
    private String venueOrMeetingLink;

    @NotNull(message = "please select conference banner")
    private MultipartFile conferenceBanner;

//    @NotNull(message = "please select conference promo video")
//    private MultipartFile promoVideo;

}
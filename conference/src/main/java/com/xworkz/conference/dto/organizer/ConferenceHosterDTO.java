package com.xworkz.conference.dto.organizer;

import com.xworkz.conference.entity.delegatesEmailEntity.DelegatesEmailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceHosterDTO {

    private Long conferenceId;

    @NotBlank(message = "Please enter your full name")
    @Size(min = 4, max = 20, message = "Full Name size must be between 4 and 20")
    private String fullName;

    @NotBlank(message = "Please enter your official email")
    @Email(message = "Invalid email format")
    private String officialEmail;

    @NotBlank(message = "Please enter your organization name")
    @Size(min = 4, max = 50, message = "Organization Name size must be between 4 and 50")
    private String organizationName;

    @NotBlank(message = "Please enter your conference title")
    @Size(min = 4, max = 50, message = "Conference title size must be between 4 and 50")
    private String conferenceTitle;


    @NotBlank(message = "Please enter conference description")
    @Size(min = 4, max = 500, message = "Conference description size must be between 4 and 500")
    private String conferenceDescription;

    @NotNull(message = "Please select valid date")
    @Future(message = "Conference date must be a future date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "Please select time")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

    @NotBlank(message = "Please select your conference mode")
    private String mode;

    @NotBlank(message = "Please mention venue or meeting link")
    @Size(min = 4, max = 500, message = "Venue/Meeting link size must be between 4 and 500")
    private String venueOrMeetingLink;

    //    @NotBlank(message = "Please enter delegates emails")
    private String delegateEmails;

    private List<DelegatesEmailEntity> delegates;
    // ⚠ File fields (validated manually in controller using .isEmpty())
    private MultipartFile conferenceBanner;
    private String bannerPath;

    private MultipartFile promoVideo;
    private String promoVideoPath;
}
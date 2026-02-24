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
public class ConferenceHosterDTO {

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

    // Target Delegates (Dropdown)
    @NotBlank(message = "Please select target delegates")
    private String targetDelegates;

    // Number of Delegates
    @NotNull(message = "Please enter number of delegates")
    @Min(value = 4, message = "Minimum 1 delegate required")
    @Max(value = 100000, message = "Maximum delegate limit exceeded")
    private Integer numberOfDelegates;

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

    // ⚠ File fields (validated manually in controller using .isEmpty())
    private MultipartFile conferenceBanner;
    private String bannerPath;

    private MultipartFile promoVideo;
    private String promoVideoPath;
}
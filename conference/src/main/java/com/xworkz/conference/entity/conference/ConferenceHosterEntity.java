package com.xworkz.conference.entity.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConferenceHosterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String officialEmail;

    private String organizationName;

    private String conferenceTitle;

    private String conferenceDescription;

    private LocalDate date;

    private LocalTime time;

    private String mode;

    private String venueOrMeetingLink;

    // Store file path instead of MultipartFile
    private String bannerPath;

    @Column(nullable = false)
    private String promoVideoPath;
}

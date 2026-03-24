package com.xworkz.conference.entity.conference;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xworkz.conference.entity.delegatesEmailEntity.DelegatesEmailEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConferenceHosterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conferenceId;

    private String fullName;

    private String officialEmail;

    private String organizationName;

    private String conferenceTitle;

    private String conferenceDescription;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalTime time;

    private String mode;

    private String venueOrMeetingLink;

    // Store file path instead of MultipartFile
    private String bannerPath;

//    @OneToMany(mappedBy = "conferenceHoster", fetch = FetchType.LAZY)
//    private List<DelegatesEmailEntity> delegates;

    @OneToMany(mappedBy = "conferenceHoster", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<DelegatesEmailEntity> delegates;

    @Column(nullable = false)
    private String promoVideoPath;

    private boolean acceptOrDecline ;

    private boolean sentToDelegates ;
}

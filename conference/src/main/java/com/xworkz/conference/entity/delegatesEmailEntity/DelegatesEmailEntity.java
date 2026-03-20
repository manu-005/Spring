package com.xworkz.conference.entity.delegatesEmailEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DelegatesEmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delegatesId;

    private String delegatesEmail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "conferenceId")
    @ToString.Exclude
    private ConferenceHosterEntity conferenceHoster;

//    private String targetDelegates;

}

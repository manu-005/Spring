package com.xworkz.conference.entity.delegatesEmailEntity;

import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DelegatesEmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delegatesId;

    private String delegatesEmail;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private ConferenceHosterEntity conferenceHoster;

}

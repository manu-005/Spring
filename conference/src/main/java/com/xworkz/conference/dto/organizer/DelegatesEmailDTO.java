package com.xworkz.conference.dto.organizer;

import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DelegatesEmailDTO {

    private int delegatesId;

    private String delegatesEmail;

    private Long conferenceId;

    private String targetDelegates;

    private String[] emailArray;

    private ConferenceHosterEntity conferenceHoster;

}
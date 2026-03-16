package com.xworkz.conference.dto.organizer;

import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DelegatesEmailDTO {

    private int delegatesId;

    private String delegatesEmail;

    private long conferenceId;

    private String targetDelegates;

}
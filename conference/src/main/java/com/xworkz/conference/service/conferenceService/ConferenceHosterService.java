package com.xworkz.conference.service.conferenceService;


import com.xworkz.conference.dto.organizer.OrganizerRegistrationDTO;

public interface ConferenceHosterService {


    boolean validAndSave(OrganizerRegistrationDTO organizerDTO);
}

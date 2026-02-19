package com.xworkz.conference.service.conferenceService;

import com.xworkz.conference.dto.organizer.OrganizerRegistrationDTO;
import org.springframework.stereotype.Service;

@Service
public class ConferenceHosterServiceImpl implements ConferenceHosterService{


    @Override
    public boolean validAndSave(OrganizerRegistrationDTO organizerDTO) {
        return false;
    }
}

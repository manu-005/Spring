package com.xworkz.conference.service.conferenceService;


import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;

import java.util.List;

public interface ConferenceHosterService {


    boolean validAndSave(ConferenceHosterDTO organizerDTO);

    List<ConferenceHosterDTO> getAllConferenceHoster();

    boolean saveGeligatesEmail(String[] email);
}

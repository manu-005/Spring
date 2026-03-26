package com.xworkz.conference.service.conferenceService;


import com.xworkz.conference.dto.admin.AdminDTO;
import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.dto.organizer.DelegatesEmailDTO;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;

import java.util.List;

public interface ConferenceHosterService {


    ConferenceHosterDTO validAndSave(ConferenceHosterDTO organizerDTO);

    List<ConferenceHosterDTO> getAllConferenceHoster();

    boolean saveDelegatesEmail(String delegatesEmails,ConferenceHosterDTO savedConferenceDTO);

    List<DelegatesEmailDTO> getAllDelegates();

    ConferenceHosterDTO getAllConferenceHosterById(Long conferenceId);

    boolean varifyAdmin(AdminDTO adminDTO);

    boolean updateAcceptOrDecline(int accepted);
}

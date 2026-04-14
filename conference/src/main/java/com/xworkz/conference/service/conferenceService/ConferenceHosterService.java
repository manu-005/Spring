package com.xworkz.conference.service.conferenceService;


import com.xworkz.conference.dto.admin.AdminDTO;
import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.dto.organizer.DelegatesEmailDTO;
import com.xworkz.conference.dto.tpoDelegates.InvitedDelegatesDTO;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

public interface ConferenceHosterService {


    ConferenceHosterDTO validAndSave(ConferenceHosterDTO organizerDTO);

    List<ConferenceHosterDTO> getAllConferenceHoster();

    boolean saveDelegatesEmail(String delegatesEmails,ConferenceHosterDTO savedConferenceDTO);

    List<DelegatesEmailDTO> getAllDelegates();

    ConferenceHosterDTO getAllConferenceHosterById(Long conferenceId);

    boolean varifyAdmin(AdminDTO adminDTO);

    boolean updateAcceptOrDecline(Long conferenceId,boolean updateAccept);

    InvitedDelegatesDTO saveInvitedDelegates(InvitedDelegatesDTO delegateDTO);

    boolean updateDelegateResponse(Long conferenceId, String delegateEmail, Boolean response);

    List<InvitedDelegatesDTO> getAvailableTpoDelegates(String sessionEmail, Long conferenceId);

    boolean updateSentToDelegates(Long conferenceId);


}

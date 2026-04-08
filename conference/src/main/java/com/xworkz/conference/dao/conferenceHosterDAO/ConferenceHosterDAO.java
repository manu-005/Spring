package com.xworkz.conference.dao.conferenceHosterDAO;

import com.xworkz.conference.entity.admin.AdminEntity;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.entity.delegatesEmailEntity.DelegatesEmailEntity;
import com.xworkz.conference.entity.tpoDelegates.InvitedDelegatesEntity;

import java.util.List;

public interface ConferenceHosterDAO {
    ConferenceHosterEntity saveConferenceHoster(ConferenceHosterEntity conferenceHosterEntity);

    List<ConferenceHosterEntity> getAllConferenceHoster();

    ConferenceHosterEntity findById(Long conferenceId);

    boolean saveAllDeligates(List<DelegatesEmailEntity> delegatesList);

    List<DelegatesEmailEntity> getAllDelegates();

    ConferenceHosterEntity getAllConferenceHosterById(Long conferenceId);

    boolean varifyAdmin(AdminEntity adminEntity);

    boolean updateAcceptOrDecline(Long conferenceId,boolean updateValue);

    InvitedDelegatesEntity saveInvitedDelegates(InvitedDelegatesEntity invitedDelegatesEntity);
}

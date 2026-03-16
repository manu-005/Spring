package com.xworkz.conference.dao.conferenceHosterDAO;

import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.entity.delegatesEmailEntity.DelegatesEmailEntity;

import java.util.List;

public interface ConferenceHosterDAO {
    ConferenceHosterEntity saveConferenceHoster(ConferenceHosterEntity conferenceHosterEntity);

    List<ConferenceHosterEntity> getAllConferenceHoster();

    ConferenceHosterEntity findById(Long conferenceId);

    boolean saveAllDeligates(List<DelegatesEmailEntity> delegatesList);

    List<DelegatesEmailEntity> getAllDelegates();
}

package com.xworkz.conference.dao.conferenceHosterDAO;

import com.xworkz.conference.entity.conference.ConferenceHosterEntity;

import java.util.List;

public interface ConferenceHosterDAO {
    boolean saveConferenceHoster(ConferenceHosterEntity conferenceHosterEntity);

    List<ConferenceHosterEntity> getAllConferenceHoster();
}

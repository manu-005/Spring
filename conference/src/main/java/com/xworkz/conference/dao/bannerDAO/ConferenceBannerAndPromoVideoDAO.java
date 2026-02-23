package com.xworkz.conference.dao.bannerDAO;

import com.xworkz.conference.entity.bannerEntity.ConferenceBannerEntity;
import com.xworkz.conference.entity.promoVideoEntity.ConferencePromoVideoEntity;

public interface ConferenceBannerAndPromoVideoDAO {
    ConferenceBannerEntity saveBanner(ConferenceBannerEntity bannerEntity);

    ConferencePromoVideoEntity svaePromoVideo(ConferencePromoVideoEntity promoVideoEntity);
}

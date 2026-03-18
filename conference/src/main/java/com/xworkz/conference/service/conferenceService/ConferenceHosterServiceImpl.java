package com.xworkz.conference.service.conferenceService;

import com.xworkz.conference.dao.bannerDAO.ConferenceBannerAndPromoVideoDAO;
import com.xworkz.conference.dao.conferenceHosterDAO.ConferenceHosterDAO;
import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.dto.organizer.DelegatesEmailDTO;
import com.xworkz.conference.entity.bannerEntity.ConferenceBannerEntity;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.entity.delegatesEmailEntity.DelegatesEmailEntity;
import com.xworkz.conference.entity.promoVideoEntity.ConferencePromoVideoEntity;
import lombok.SneakyThrows;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConferenceHosterServiceImpl implements ConferenceHosterService {

    @Autowired
    ConferenceHosterDAO conferenceHosterDAO;

    @Autowired
    ConferenceBannerAndPromoVideoDAO conferenceBannerAndPromoVideoDAO;

    @SneakyThrows
    @Override
    public ConferenceHosterDTO validAndSave(ConferenceHosterDTO organizerDTO) {
        System.out.println("service  started.. valid and save");
        System.out.println("service dto:" + organizerDTO);

        //1  banner Image
        MultipartFile bannerImage = organizerDTO.getConferenceBanner();

        String uploadDir = "D:\\projectUploadedImages\\";
        String bannerName = System.currentTimeMillis() + "_" + bannerImage.getOriginalFilename();
        Path bannerPath = Paths.get(uploadDir + bannerName);
        Files.createDirectories(bannerPath.getParent());   // ensure folder exists
        byte[] bannerBytes = bannerImage.getBytes();
        Files.write(bannerPath, bannerBytes);

        // 2 Save banner file info
        ConferenceBannerEntity bannerEntity = new ConferenceBannerEntity();
        bannerEntity.setBannerName(bannerImage.getOriginalFilename());
        bannerEntity.setBannerType(bannerImage.getContentType());
        bannerEntity.setBannerPath(bannerPath.toString());
        bannerEntity.setBannerSize(bannerImage.getSize());
        System.out.println("service banner details :" + bannerEntity);

        //save conference banner details db
        ConferenceBannerEntity savedBanner = conferenceBannerAndPromoVideoDAO.saveBanner(bannerEntity);
        System.out.println("banner path saved : " + bannerPath);
        // 1. promo video
        MultipartFile promoVideo = organizerDTO.getPromoVideo();

        String promoVidDir = "D:\\projectUploadVideos\\";   //path to store
        String promoVideoName = System.currentTimeMillis() + "_" + promoVideo.getOriginalFilename();     // unique name to store
        Path promoVideoPath = Paths.get(promoVidDir + promoVideoName);
        Files.createDirectories((promoVideoPath.getParent()));  // check exist or not for dir
        byte[] promoBytes = promoVideo.getBytes();
        Files.write(promoVideoPath, promoBytes);
        //2. set promo video entity field  details
        ConferencePromoVideoEntity promoVideoEntity = new ConferencePromoVideoEntity();

        promoVideoEntity.setPromoVideoName(promoVideo.getOriginalFilename());
        promoVideoEntity.setPromoVideoType(promoVideo.getContentType());
        promoVideoEntity.setPromoVideoPath(promoVideoPath.toString());
        promoVideoEntity.setPromoVideoSize(promoVideo.getSize());
        //save conference promo video details db
        ConferencePromoVideoEntity savedPromoVideoEntity = conferenceBannerAndPromoVideoDAO.svaePromoVideo(promoVideoEntity);

        ConferenceHosterEntity conferenceHosterEntity = new ConferenceHosterEntity();

        BeanUtils.copyProperties(organizerDTO, conferenceHosterEntity);

        conferenceHosterEntity.setBannerPath(savedBanner.getBannerPath());
        conferenceHosterEntity.setPromoVideoPath(savedPromoVideoEntity.getPromoVideoPath());

        if (savedBanner != null && savedPromoVideoEntity != null) {

            System.out.println("saved banner :" + savedBanner);
            System.out.println("saved promo video :" + savedPromoVideoEntity);
            System.out.println("hoster entity :" + conferenceHosterEntity);

            ConferenceHosterEntity savedConferenceEntity = conferenceHosterDAO.saveConferenceHoster(conferenceHosterEntity);

            ConferenceHosterDTO savedDto = new ConferenceHosterDTO();

            BeanUtils.copyProperties(savedConferenceEntity, savedDto);

            System.out.println("after saved and bean utils :" + savedDto);

            return savedDto;
        }
        return null;
    }

    @Override
    public List<ConferenceHosterDTO> getAllConferenceHoster() {

        List<ConferenceHosterEntity> allEntityList = conferenceHosterDAO.getAllConferenceHoster();
        System.out.println("all conference in service :"+allEntityList);

//        for (ConferenceHosterEntity hoster : allEntityList) {
//            System.out.println("Conference Title service : " + hoster.getConferenceTitle());
//            System.out.println("Delegates: " + hoster.getDelegates());
//        }

        List<ConferenceHosterDTO> dtoList = new ArrayList<>();

        if (allEntityList != null && !allEntityList.isEmpty()) {

            for (ConferenceHosterEntity entity : allEntityList) {

                ConferenceHosterDTO dto = new ConferenceHosterDTO();
                System.out.println("delegates in service :"+entity.getDelegates());

                BeanUtils.copyProperties(entity, dto);
                dtoList.add(dto);
            }
        }

//        for (ConferenceHosterDTO hoster : dtoList) {
//            System.out.println("Conference Title service after : " + hoster.getConferenceTitle());
//            System.out.println("Delegates: " + hoster.getDelegates());
//        }

        System.out.println("after bean utils :"+dtoList);
        return dtoList;
    }

    @Override
    public boolean saveDelegatesEmail(String[] delegatesEmails, ConferenceHosterDTO savedConferenceDTO) {
        System.out.println("service for delegates  :==");

        ConferenceHosterEntity fetchEntityById = conferenceHosterDAO.findById(savedConferenceDTO.getConferenceId());


        List<DelegatesEmailEntity> delegatesList = new ArrayList<>();

        for (String email : delegatesEmails) {
            System.out.println("all delegates mail in service :" + email.trim());

            DelegatesEmailEntity delegatesEmailEntity = new DelegatesEmailEntity();

            delegatesEmailEntity.setDelegatesEmail(email);
            delegatesEmailEntity.setConferenceHoster(fetchEntityById);

            delegatesList.add(delegatesEmailEntity);

            return conferenceHosterDAO.saveAllDeligates(delegatesList);
        }
        return false;
    }

    @Override
    public List<DelegatesEmailDTO> getAllDelegates() {

      List<DelegatesEmailEntity> allDelegates =  conferenceHosterDAO.getAllDelegates();
        System.out.println("all delegates in service :"+allDelegates);

        List<DelegatesEmailDTO> delegates = new ArrayList<>();

        for(DelegatesEmailEntity entity : allDelegates){

            DelegatesEmailDTO dto = new DelegatesEmailDTO();

//            dto.setDelegatesId(entity.getDelegatesId());
//            dto.setTargetDelegates(entity.getTargetDelegates());

            BeanUtils.copyProperties(entity,dto);
            delegates.add(dto);
        }

        System.out.println("all delegates in service after bean utils :"+delegates);

        return delegates;
    }

    @Override
    public ConferenceHosterDTO getAllConferenceHosterById(Long conferenceId) {
        ConferenceHosterEntity entity = conferenceHosterDAO.getAllConferenceHosterById(conferenceId);

        ConferenceHosterDTO dto = new ConferenceHosterDTO();

        BeanUtils.copyProperties(entity,dto);
        System.out.println("entity in service after bean utils  :"+dto);
        return dto;
    }


}

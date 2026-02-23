package com.xworkz.conference.service.conferenceService;

import com.xworkz.conference.dao.bannerDAO.ConferenceBannerDAO;
import com.xworkz.conference.dto.organizer.OrganizerRegistrationDTO;
import com.xworkz.conference.entity.bannerEntity.ConferenceBannerEntity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ConferenceHosterServiceImpl implements ConferenceHosterService {

    @Autowired
    ConferenceBannerDAO conferenceBannerDAO;

    @SneakyThrows
    @Override
    public boolean validAndSave(OrganizerRegistrationDTO organizerDTO) {
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
        //save conference banner details db
        ConferenceBannerEntity savedBanner = conferenceBannerDAO.saveBanner(bannerEntity);
        System.out.println("banner path saved : " + bannerPath);

        // 1. promo video
        MultipartFile promoVideo = organizerDTO.getPromoVideo();

        String promoVidDir = "D:\\projectUploadVideos\\";   //path to store
        String promoVideoName = System.currentTimeMillis() + "_" +promoVideo.getOriginalFilename();     // unique name to store
        Path promoVideoPath = Paths.get(promoVidDir + promoVideoName);
        Files.createDirectories((promoVideoPath.getParent()));  // check exist or not for dir
        byte[] promoBytes = promoVideo.getBytes();
        Files.write(promoVideoPath, promoBytes);

        //2. set promo video entity field  details
        ConferencePromoVideoEntity



        return false;
    }
}

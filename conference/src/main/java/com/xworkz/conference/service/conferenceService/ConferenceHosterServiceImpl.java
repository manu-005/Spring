package com.xworkz.conference.service.conferenceService;

import com.xworkz.conference.dao.bannerDAO.ConferenceBannerDAO;
import com.xworkz.conference.dto.organizer.OrganizerRegistrationDTO;
import com.xworkz.conference.entity.bannerEntity.ConferenceBannerEntity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ConferenceHosterServiceImpl implements ConferenceHosterService{

    @Autowired
    ConferenceBannerDAO conferenceBannerDAO;
@SneakyThrows
    @Override
    public boolean validAndSave(OrganizerRegistrationDTO organizerDTO) {
        System.out.println("service  started.. valid and save");
        System.out.println("service dto:" +organizerDTO);

        //  Profile Image
        MultipartFile file = organizerDTO.getConferenceBanner();

        String uploadDir = "D:\\projectUploadedImages\\";
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + fileName);

        Files.createDirectories(path.getParent());   // ensure folder exists
        byte[] bytes = file.getBytes();
        Files.write(path, bytes);

    // 2️⃣ Save file info
    ConferenceBannerEntity bannerEntity = new ConferenceBannerEntity();
    bannerEntity.setBannerName(file.getOriginalFilename());
    bannerEntity.setBannerType(file.getContentType());
    bannerEntity.setBannerPath(path.toString());
    bannerEntity.setBannerSize(file.getSize());


    ConferenceBannerEntity savedBanner = conferenceBannerDAO.saveBanner(bannerEntity);

        System.out.println("file path: " + path);

        return false;
    }
}

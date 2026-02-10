package com.xworkz.xworkzModel.service.batchService;

import com.xworkz.xworkzModel.dao.batchDao.BatchDao;
import com.xworkz.xworkzModel.dao.fileDao.FileDao;
import com.xworkz.xworkzModel.dto.batchdto.BatchDTO;
import com.xworkz.xworkzModel.entity.batchEntity.BatchEntity;
import com.xworkz.xworkzModel.entity.fileentity.FileEntity;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchDao dao;

    @Autowired
    FileDao fileDao;

    @Override
    @SneakyThrows
    public boolean addNewBatch(BatchDTO dto) {
        System.out.println("service started to save batch..");

        BatchEntity batchEntity= new BatchEntity();

        MultipartFile file = dto.getBatchImage();
        byte[] bytes = file.getBytes();

        Path path = Paths.get("D:\\projectUploadedImages\\" + file.getOriginalFilename() + System.currentTimeMillis() + ".jpg");
        System.out.println("file path"+path);

//        fileEntity.setId(dto.getBatchId());
        Files.write(path, bytes);

        FileEntity fileEntity = new FileEntity();

        fileEntity.setOriginalFileName(file.getOriginalFilename());
        fileEntity.setFileDataBytes(file.getBytes());
        fileEntity.setFileType(file.getContentType());
        fileEntity.setFilePath(String.valueOf(path));//path
        fileEntity.setFileSize(file.getSize());

        boolean fileInfoSaved =fileDao.save(fileEntity);


//        BeanUtils.copyProperties(dto,entity);

//        return dao.savebatch(entity);
        return  true;
    }
    @Override
    public List<BatchDTO> getAllBatch() {

        System.out.println("getting all batches in service");

        List<BatchEntity> entities = dao.getAllBatch();

        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        List<BatchDTO> dtoList = new ArrayList<>();

        for (BatchEntity entity : entities) {
            BatchDTO dto = new BatchDTO();
            BeanUtils.copyProperties(entity, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public BatchDTO fetchById(int batchId) {
        BatchDTO dto = new BatchDTO();
      BatchEntity entity =  dao.fetchById(batchId);

      BeanUtils.copyProperties(entity,dto);

        return dto;
    }

}

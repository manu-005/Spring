package com.xworkz.xworkzModel.service.batchService;

import com.xworkz.xworkzModel.dao.batchDao.BatchDao;
import com.xworkz.xworkzModel.dto.batchdto.BatchDTO;
import com.xworkz.xworkzModel.entity.batchEntity.BatchEntity;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchDao dao;

    @Override
    public boolean addNewBatch(BatchDTO dto) {
        System.out.println("service started to save batch..");

        BatchEntity entity = new BatchEntity();

        BeanUtils.copyProperties(dto,entity);
        dao.savebatch(entity);

        return false;
    }
}

package com.xworkz.xworkzModel.service.batchService;

import com.xworkz.xworkzModel.dto.batchdto.BatchDTO;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {
    @Override
    public boolean addNewBatch(BatchDTO dto) {
        System.out.println("service started to save batch..");


        return false;
    }
}

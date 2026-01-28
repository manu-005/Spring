package com.xworkz.xworkzModel.dao.batchDao;

import com.xworkz.xworkzModel.dto.batchdto.BatchDTO;
import com.xworkz.xworkzModel.entity.batchEntity.BatchEntity;
import org.springframework.stereotype.Repository;

public interface BatchDao {
    boolean savebatch(BatchEntity entity);
}

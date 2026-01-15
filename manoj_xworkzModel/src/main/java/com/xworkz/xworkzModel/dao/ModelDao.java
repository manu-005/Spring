package com.xworkz.xworkzModel.dao;

import com.xworkz.xworkzModel.dto.UserDto;
import com.xworkz.xworkzModel.entity.UserEntity;

public interface ModelDao {

    boolean save(UserEntity entity);
}

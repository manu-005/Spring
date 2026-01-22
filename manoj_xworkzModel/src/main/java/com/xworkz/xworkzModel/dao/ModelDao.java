package com.xworkz.xworkzModel.dao;

import com.xworkz.xworkzModel.dto.UserDto;
import com.xworkz.xworkzModel.entity.UserEntity;

import java.util.Optional;

public interface ModelDao {

    boolean save(UserEntity entity);

    UserEntity checkEmailAndPassword(String email, String password);

    UserEntity findByEmail(String email);

    UserEntity updateFailedAttempts(UserEntity entity);

    int getFailedAttemptsByDB(int id);

    boolean setAttemptsZero(int id, int i);
}

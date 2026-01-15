package com.xworkz.xworkzModel.service;

import com.xworkz.xworkzModel.dao.ModelDao;
import com.xworkz.xworkzModel.dto.UserDto;
import com.xworkz.xworkzModel.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelDao dao;

    private static final byte[] keyValue = "1234567890123456".getBytes();


    @Override
    public boolean validAndSave(UserDto dto) {


        boolean valid = true;

        if (dto == null) {
            return false;
        }

        // First Name
        if (dto.getFName() == null || dto.getFName().trim().length() <= 5) {
            valid = false;
        }

        // Last Name
        if (dto.getLName() == null || dto.getLName().trim().length() <= 5) {
            valid = false;
        }

        // Age
        if (dto.getAge() <= 18) {
            valid = false;
        }

        // Gender
        if (dto.getGender() == null || dto.getGender().trim().isEmpty()) {
            valid = false;
        }

        // Email
        if (dto.getEmail() == null || !dto.getEmail().endsWith("@gmail.com")) {
            valid = false;
        }

        // Mobile
        String mobile = String.valueOf(dto.getMobile());
        if (!mobile.matches("[6-9][0-9]{9}")) {
            valid = false;
        }

        if (valid) {
            System.out.println("All validations passed. Save logic here.");


            try {
                String encryptedPassword = encryptPassword(dto.getPassword());
                dto.setPassword(encryptedPassword);

                UserEntity entity = new UserEntity();

                BeanUtils.copyProperties(dto,entity);
                return dao.save(entity);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        return valid;
    }

    private String encryptPassword(String password) throws Exception {
        SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }
}

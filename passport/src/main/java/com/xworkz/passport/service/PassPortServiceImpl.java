package com.xworkz.passport.service;

import com.xworkz.passport.dao.PassPortDAO;
import com.xworkz.passport.dto.PassPortRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassPortServiceImpl implements  PassPortService{

    @Autowired
    PassPortDAO passPortDAO;

    @Override
    public boolean validSave(PassPortRegisterDTO passPortRegisterDTO) {

        if (passPortRegisterDTO != null){
            boolean save = passPortDAO.save(passPortRegisterDTO);
            if (save){
                return true;
            }
        }
        return false;
    }
}

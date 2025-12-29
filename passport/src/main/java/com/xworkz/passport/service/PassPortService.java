package com.xworkz.passport.service;

import com.xworkz.passport.dto.PassPortRegisterDTO;

public interface PassPortService {


    boolean validSave(PassPortRegisterDTO passPortRegisterDTO);

    boolean delete(int id);
}

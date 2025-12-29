package com.xworkz.passport.dao;

import com.xworkz.passport.dto.PassPortRegisterDTO;

public interface PassPortDAO {
    boolean save(PassPortRegisterDTO passPortRegisterDTO);

    boolean delete(int id);
}

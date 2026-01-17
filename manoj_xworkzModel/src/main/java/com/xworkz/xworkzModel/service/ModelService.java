package com.xworkz.xworkzModel.service;

import com.xworkz.xworkzModel.dto.UserDto;

public interface ModelService {
    boolean validAndSave(UserDto dto);

    boolean signIn(String email, String password);
}

package com.xworkz.bloodBank.dao;

import com.xworkz.bloodBank.dto.BloodDonorDTO;
import com.xworkz.bloodBank.entity.DonorEntity;

import java.util.Optional;

public interface BloodBankDAO {

    boolean saved(DonorEntity entity);

    Optional<BloodDonorDTO> searchByEmail(String searchEmail);

    Optional<BloodDonorDTO> getById(int id);

    boolean update(BloodDonorDTO bloodDonorDTO);

    boolean delete(int id);
}

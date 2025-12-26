package com.xworkz.bloodBank.service;

import com.xworkz.bloodBank.dto.BloodDonorDTO;

import java.util.Optional;


public interface BloodBankService {


    boolean validAndSave(BloodDonorDTO bloodDonorDTO);

    Optional<BloodDonorDTO> validEmail(String searchEmail);

    Optional<BloodDonorDTO> validId(int id);

    boolean validUpdate(BloodDonorDTO bloodDonorDTO);

    boolean validdelete(int id);
}

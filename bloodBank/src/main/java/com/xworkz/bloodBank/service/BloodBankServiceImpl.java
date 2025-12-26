package com.xworkz.bloodBank.service;

import com.xworkz.bloodBank.dao.BloodBankDAO;
import com.xworkz.bloodBank.dto.BloodDonorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BloodBankServiceImpl implements BloodBankService{

    @Autowired
    BloodBankDAO bloodBankDAO;
    @Override
    public boolean validAndSave(BloodDonorDTO bloodDonorDTO) {

        if (bloodDonorDTO != null){

         boolean saved =  bloodBankDAO.saved(bloodDonorDTO);
         if (saved){
             return true;
         }
        }

        return false;
    }

    @Override
    public Optional<BloodDonorDTO> validEmail(String searchEmail) {
        if (searchEmail != null){
        Optional<BloodDonorDTO> dto =    bloodBankDAO.searchByEmail(searchEmail);
        if (dto.isPresent()){
            return  dto;
        }
        }

        return Optional.empty();
    }

    @Override
    public Optional<BloodDonorDTO> validId(int id) {

        if (id>=1){
            Optional<BloodDonorDTO> updateDto = bloodBankDAO.getById(id);

            if (updateDto.isPresent()) {
                return updateDto;
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean validUpdate(BloodDonorDTO bloodDonorDTO) {

        if (bloodDonorDTO != null){

            boolean update = bloodBankDAO.update(bloodDonorDTO);

            if (update){
                return true;
            }
        }



        return false;
    }

    @Override
    public boolean validdelete(int id) {

        if (id >=1){
          boolean delete =  bloodBankDAO.delete(id);

          if (delete){
              return true;
          }
        }

        return false;
    }
}

package com.xworkz.medicine.service;

import com.xworkz.medicine.dao.MedicineDAO;
import com.xworkz.medicine.dao.MedicineDAOImpl;
import com.xworkz.medicine.dto.MedicineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicineServiceImpl implements MedicineService{

    @Autowired
    MedicineDAO medicineDAO;

    @Override
    public boolean validateAndSave(MedicineDTO medicineDTO) {
        boolean invalid=false;

        if (medicineDTO != null){

            if (medicineDTO.getName().trim().isEmpty() || medicineDTO.getName().trim().length() <= 2){
                invalid = true;
                System.out.println("invalid name");
            }
            if (medicineDTO.getMg().trim().isEmpty() || medicineDTO.getMg().trim().length() <= 2){
                invalid = true;
            }
            if (medicineDTO.getCombination().trim().isEmpty() || medicineDTO.getCombination().trim().length() <= 2){
                invalid = true;
            }
            if (medicineDTO.getExpireDate().trim().isEmpty() || medicineDTO.getExpireDate().trim().length() <= 2){
                invalid = true;
            }
            if (medicineDTO.getPrice() <= 0 ){
                invalid = true;
            }
        }
        if (!invalid){
          boolean saved =  medicineDAO.save(medicineDTO);

          if (saved){
              invalid=false;
          }
        }
        return invalid;
    }

    @Override
    public boolean delete(String name) {
        return medicineDAO.delete(name);

    }
}

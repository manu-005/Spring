package com.xworkz.medicine.service;

import com.xworkz.medicine.dto.MedicineDTO;

public interface MedicineService {

boolean validateAndSave(MedicineDTO medicineDTO);

    boolean delete(String name);
}

package com.xworkz.medicine.dao;

import com.xworkz.medicine.dto.MedicineDTO;

public interface MedicineDAO {
    boolean save(MedicineDTO medicineDTO);

    boolean delete(String name);
}

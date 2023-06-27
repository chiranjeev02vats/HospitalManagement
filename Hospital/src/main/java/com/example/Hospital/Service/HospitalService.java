package com.example.Hospital.Service;

import com.example.Hospital.Dto.HospitalDto;

import java.util.List;

public interface HospitalService {

    List<HospitalDto> getAllPatients();

    String createNewPatient(HospitalDto hospitalDto);

    String updateExistingPatient(HospitalDto hospitalDto);

    String deletePatient(Long id);

    List<HospitalDto> getAllPatientsById(Long id);

    List<HospitalDto> getAllActivePatients();

    List<HospitalDto> getAllDischargedPatients();
}

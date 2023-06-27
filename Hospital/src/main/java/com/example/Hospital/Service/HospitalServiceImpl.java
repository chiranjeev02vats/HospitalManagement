package com.example.Hospital.Service;

import com.example.Hospital.Dal.HospitalRepository;
import com.example.Hospital.Dto.HospitalDto;
import com.example.Hospital.Entity.HospitalEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<HospitalDto> getAllPatients() {
        List<HospitalEntity> hospitalEntities = (List<HospitalEntity>) hospitalRepository.findAll();
        return Collections.singletonList(modelMapper.map(hospitalEntities, HospitalDto.class));
    }

    @Override
    public String createNewPatient(HospitalDto hospitalDto) {
        if (hospitalDto != null) {
            HospitalEntity hospitalEntity = null;
            hospitalEntity = modelMapper.map(hospitalDto, HospitalEntity.class);
            hospitalEntity.setAdmittedDate(LocalDateTime.now());
            hospitalEntity.setStatus("Admitted");
            hospitalRepository.save(hospitalEntity);
            return "New Patient Saved Successfully";
        } else
            return "please fill all fields";
    }

    @Override
    public String updateExistingPatient(HospitalDto hospitalDto) {
        HospitalEntity hospitalEntity = null;
        if (hospitalDto.getId() != null) {
            Optional<HospitalEntity> existingPatient = (Optional<HospitalEntity>) hospitalRepository.findById(hospitalDto.getId());
            if (existingPatient.isPresent()) {
                hospitalEntity = existingPatient.get();
                hospitalEntity.setModifiedOn(LocalDateTime.now());
                modelMapper.map(hospitalDto, hospitalEntity);
                hospitalRepository.save(hospitalEntity);
                return "Sucessfully Updated";
            } else {
                return "No Record Found";

            }
        }
        return "Syntax error";
    }

    @Override
    public String deletePatient(Long id) {
        HospitalEntity hospitalEntity = null;
        if (id != null) {
            Optional<HospitalEntity> existingPatient = (Optional<HospitalEntity>) hospitalRepository.findById(id);
            if (existingPatient.isPresent()) {
                hospitalEntity = existingPatient.get();
                hospitalEntity.setModifiedOn(LocalDateTime.now());
                hospitalEntity.setIsAcive(Boolean.FALSE);
                hospitalEntity.setStatus("Discharged");
                hospitalRepository.save(hospitalEntity);
                return "Sucessfully Deleted";
            } else {
                return "No Record Found";

            }
        }
        return "Syntax error";
    }

    @Override
    public List<HospitalDto> getAllPatientsById(Long id) {
        Optional<HospitalEntity> hospitalEntities = hospitalRepository.findById(id);
        return Collections.singletonList(modelMapper.map(hospitalEntities, HospitalDto.class));
    }

    @Override
    public List<HospitalDto> getAllActivePatients() {
        List<HospitalEntity> hospitalEntities = hospitalRepository.getAllActivePatients(Boolean.TRUE);
        return Collections.singletonList(modelMapper.map(hospitalEntities, HospitalDto.class));
    }

    @Override
    public List<HospitalDto> getAllDischargedPatients()
    {
        List<HospitalEntity> hospitalEntities = hospitalRepository.getAllDischargedPatients("Discharged");
        return Collections.singletonList(modelMapper.map(hospitalEntities,HospitalDto.class));
    }

}
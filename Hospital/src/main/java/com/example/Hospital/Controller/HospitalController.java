package com.example.Hospital.Controller;
import com.example.Hospital.Dto.HospitalDto;
import com.example.Hospital.Exceptions.HospitalExceptions;
import com.example.Hospital.Service.HospitalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/hospital")
@CrossOrigin(origins = "*")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;
    @GetMapping(value = "/getAllInformationAboutHospital", produces = "application/json")
    @ApiOperation(value = "All Admitted Patients", response = ResponseEntity.class)
    public ResponseEntity getAllPatients() {
        try {
            List<HospitalDto> hospitalDtos = hospitalService.getAllPatients();
            return new ResponseEntity(hospitalDtos, HttpStatus.OK);
        } catch (HospitalExceptions e) {
            return new ResponseEntity((e.getJSON()), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value = "/getAllActivePatients", produces = "application/json")
    @ApiOperation(value = "Get all Active Patients", response = ResponseEntity.class)
    public ResponseEntity getAllActivePatients() {
        try {
            List<HospitalDto> hospitalDtos = hospitalService.getAllActivePatients();
            return new ResponseEntity(hospitalDtos, HttpStatus.OK);
        } catch (HospitalExceptions e) {
            return new ResponseEntity((e.getJSON()), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value = "/getAllDischargedPatientInformation", produces = "application/json")
    @ApiOperation(value = "Get All Discharged Patient", response = ResponseEntity.class)
    public ResponseEntity getAllDischargedPatients() {
        try {
            List<HospitalDto> hospitalDtos = hospitalService.getAllDischargedPatients();
            return new ResponseEntity(hospitalDtos, HttpStatus.OK);
        } catch (HospitalExceptions e) {
            return new ResponseEntity((e.getJSON()), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value = "/getPatientById", produces = "application/json")
    @ApiOperation(value = "Get Patient by id", response = ResponseEntity.class)
    public ResponseEntity getAll(@RequestParam Long id) {
        try {
            List<HospitalDto> hospitalDtos = hospitalService.getAllPatientsById(id);
            return new ResponseEntity(hospitalDtos, HttpStatus.OK);
        } catch (HospitalExceptions e) {
            return new ResponseEntity((e.getJSON()), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(value = "/createPatient", produces = "application/json")
    @ApiOperation(value = "Create new Patient", response = ResponseEntity.class)
    public ResponseEntity registerNewPatient(@RequestBody HospitalDto hospitalDto) {
        try {
            return new ResponseEntity(hospitalService.createNewPatient(hospitalDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping(value = "/deletePatient", produces = "application/json")
    @ApiOperation(value = "Delete existing Patient", response = ResponseEntity.class)
    public ResponseEntity deleteFourPoint(@RequestParam(value = "PatientId") Long id) {
        try {
            return new ResponseEntity(hospitalService.deletePatient(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PutMapping(value = "/updatePatient", produces = "application/json")
    @ApiOperation(value = "Update existing patient status", response = ResponseEntity.class)
    public ResponseEntity updateTestPlanGroup(@RequestBody final HospitalDto hospitalDto) {
        try {
            String message = hospitalService.updateExistingPatient(hospitalDto);
            return new ResponseEntity(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
    }

}

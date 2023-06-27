package com.example.Hospital.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Entity
@Table(name ="hospital_management")
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name ="patient_age")
    private Long patientAge;

    @Column(name ="room_number")
    private String roomNumber;

    @Column(name ="allocated_doctor_name")
    private String doctorName;

    @Column(name ="admitted_date")
    private LocalDateTime admittedDate;

    @Column(name="hospital_expenses")
    private Double hospitalExpenses;

    @Column(name ="modified_on")
    private LocalDateTime modifiedOn;

    private String status;

    private Boolean isAcive;

}

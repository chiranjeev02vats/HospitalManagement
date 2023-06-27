package com.example.Hospital.Dto;
import lombok.*;

import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@Builder
@Data
@NoArgsConstructor
public class HospitalDto {

    @Id
    private Long id;

    private String patientName;

    private Long patientAge;

    private String roomNumber;

    private String doctorName;

    private LocalDateTime admittedDate;

    private Double hospitalExpenses;

    private String status;

    private Boolean isActive;
}

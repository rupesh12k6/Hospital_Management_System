package org.example.hospital_manage.entity.clinicalModule;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.hospital_manage.entity.BaseEntity;


@Entity
@Getter
@Setter
@Table
public class Prescription extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_record_id", nullable = false)
    private MedicalRecord medicalRecord;

    @Column(nullable = false, unique = true)
    private String prescriptionCode;

    @Lob
    private String generalAdvice;



}

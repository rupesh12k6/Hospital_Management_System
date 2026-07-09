package org.example.hospital_manage.entity.clinicalModule;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.hospital_manage.entity.Appointment;
import org.example.hospital_manage.entity.BaseEntity;

import java.time.LocalDate;
@Entity
@Setter
@Getter
@Table(name="medicalrecord")
public class MedicalRecord extends BaseEntity {

    @Column(nullable = false, unique = true, length = 20)
    private String medicalRecordCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="appointment_id",
            nullable=false,
            unique=true
    )
    private Appointment appointment;

    @NotBlank
    @Column(nullable = false,length=500)
    private String chiefComplaint;

    @Lob
    private String historyOfPresentIllness;

    @NotBlank
    @Lob
    private String diagnosis;

    @Lob
    private String clinicalNotes;

    @Column
    private LocalDate followUpDate;

}

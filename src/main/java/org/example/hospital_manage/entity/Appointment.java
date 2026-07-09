package org.example.hospital_manage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hospital_manage.enums.AppointmentStatus;
import org.example.hospital_manage.enums.AppointmentType;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "appointments",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_doctor_slot",
                        columnNames = {"doctor_id", "appointment_date", "appointment_time"}
                )
        },
        indexes = {

                @Index(name = "idx_patient", columnList = "patient_id"),
                @Index(name = "idx_doctor", columnList = "doctor_id"),
                @Index(name = "idx_status", columnList = "status"),
                @Index(name = "idx_appointment_date", columnList = "appointment_date"),
                @Index(name = "idx_doctor_date_time", columnList = "doctor_id,appointment_date,appointment_time")

        }
)
public class Appointment extends BaseEntity{

    @Column(nullable = false, unique = true, length = 20)
    private String appointmentCode;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id",nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="receptionist_id")
    private Receptionist receptionist;

    @Column(nullable = false)
    private LocalDate appointmentDate;

    @Column(nullable = false)
    private LocalTime appointmentTime;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String reasonForAppointment;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentType appointmentType;

    @Column(length = 500)
    private String remarks;





}

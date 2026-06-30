package org.example.hospital_manage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.example.hospital_manage.enums.BloodGroup;
import org.example.hospital_manage.enums.Gender;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "patients",
        indexes = {
                @Index(name = "idx_patient_name", columnList = "firstName,lastName"),
                @Index(name = "idx_patient_aadhaar", columnList = "aadhaar")
        }
)
public class Patient extends BaseEntity{


    /**
     * Authentication Account
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            unique = true
    )
    private User user;

    @NotBlank(message = "First name is required")
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(nullable = false, length = 50)
    private String lastName;



    @Pattern(
            regexp = "^([2-9]{1}[0-9]{11})?$",
            message = "Invalid Aadhaar Number"
    )
    @Column(length = 12)
    private String aadhaar;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @NotNull
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private BloodGroup bloodGroup;

    @Column(length = 255)
    private String address;

    @Column(length = 100)
    private String guardianName;

    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Invalid guardian phone"
    )
    @Column(length = 10)
    private String guardianPhone;

    @Column(length = 100)
    private String emergencyContactName;

    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Invalid emergency contact number"
    )
    @Column(length = 10)
    private String emergencyContactPhone;

}
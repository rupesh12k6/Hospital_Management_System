package org.example.hospital_manage.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;
import org.example.hospital_manage.enums.Department;
import org.example.hospital_manage.enums.Gender;
import org.example.hospital_manage.enums.Role;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "doctors",
        indexes = {
                @Index(name="idx_doctor_specialization", columnList="specialization"),
                @Index(name="idx_doctor_department", columnList="department"),
                @Index(name="idx_doctor_license", columnList="licenseNumber")
        }
)
public class Doctor extends BaseEntity{
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            unique = true
    )
    private User user;
   @NotBlank
    @Column
    private String firstName;
    @Column
    @NotBlank
    private String lastName;
    @NotBlank
    @Column
    private String specialization;
    @NotBlank
    @Column
    private String licenseNumber;
    @Column
    @NotNull
    @Min(0)
    @Max(60)
    private int experience;
    @Column
    @NotNull
    private Department department;
    @Column
    @NotNull
    private double consultationFee;

    @NotNull
    @Column( nullable = false, length = 10)
    private Gender gender;
    @Column(length = 1000)
    private String bio;
    private String profileImg;


}

package org.example.hospital_manage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hospital_manage.enums.Gender;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(
        name = "receptionists",
        indexes = {
                @Index(name = "idx_receptionist_email", columnList = "email"),
                @Index(name = "idx_receptionist_phone", columnList = "phone")
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Receptionist extends BaseEntity{
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            unique = true
    )
    private User user;

    @NotBlank(message = "Username is required")
    @Column(nullable = false, unique = true, length = 20)
    private String userCode;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private LocalDate joiningDate;

    @Column(nullable = false)
    private Boolean active;


}

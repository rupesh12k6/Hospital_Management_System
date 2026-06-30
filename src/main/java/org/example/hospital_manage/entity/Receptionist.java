package org.example.hospital_manage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column
    private String firstName;

    @Column
    private String lastName;



}

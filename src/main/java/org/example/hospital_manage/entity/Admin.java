package org.example.hospital_manage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="admins")
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends BaseEntity{
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

    @Column
    private String firstName;
    @Column
    private String lastName;


}

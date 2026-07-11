package org.example.hospital_manage.entity.billingModule;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hospital_manage.entity.Appointment;
import org.example.hospital_manage.entity.BaseEntity;
import org.example.hospital_manage.entity.Patient;
import org.example.hospital_manage.enums.BillStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "bills",
        indexes = {
                @Index(name = "idx_bill_date", columnList = "bill_date"),
                @Index(name = "idx_bill_status", columnList = "status")
        }
)
public class Bill extends BaseEntity {

    @Column(nullable = false, unique = true, length = 20)
    private String billCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "appointment_id",
            nullable = false,
            unique = true
    )
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "patient_id",
            nullable = false
    )
    private Patient patient;



    @NotNull
    @Column(name = "bill_date", nullable = false)
    private LocalDate billDate;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal discount = BigDecimal.ZERO;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tax = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal finalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillStatus status;

    @Column(length = 300)
    private String remarks;
}
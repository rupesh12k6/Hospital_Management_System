package org.example.hospital_manage.entity.billingModule;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.hospital_manage.entity.BaseEntity;
import org.example.hospital_manage.enums.PaymentMethod;
import org.example.hospital_manage.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Payment extends BaseEntity {
    @Column(nullable = true, unique = true)
    private String paymentCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, unique = true)
    private Bill bill;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column
    private String transactionId;

    @Column
    private LocalDateTime paymentDate;
    @NotNull
    @Column
    private BigDecimal amount;
}

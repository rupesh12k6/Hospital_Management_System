package org.example.hospital_manage.entity.billingModule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hospital_manage.entity.BaseEntity;
import org.example.hospital_manage.enums.ServiceType;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChargeCatalog extends BaseEntity {
    @Column(
            nullable = false,
            unique = true,
            length = 20
    )
    private  String chargeCode;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private ServiceType  serviceType;

    @Column(
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal unitPrice;

    @Column(nullable = false,length = 20)
    private String unit;

    @Column(nullable=false)
    private Boolean taxable;

    @Column(nullable = false)
    private Boolean active;

}

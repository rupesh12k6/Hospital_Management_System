package org.example.hospital_manage.entity.billingModule;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.hospital_manage.entity.BaseEntity;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "bill_items",
        indexes = {
                @Index(name = "idx_bill_item_bill", columnList = "bill_id"),
                @Index(name = "idx_bill_item_service", columnList = "service_type")
        }
)
public class BillItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="chargeCatalog_id", nullable = false)
    private ChargeCatalog chargeCatalog;

    @Column(nullable = false, length = 100)
    private String serviceNameSnapshot;

    @Column
    private BigDecimal unitPriceSnapshot;

    @NotNull
    @Column(nullable = false)
    private Integer quantity = 1;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;
}
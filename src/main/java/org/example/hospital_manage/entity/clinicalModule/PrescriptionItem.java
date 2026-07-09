package org.example.hospital_manage.entity.clinicalModule;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.hospital_manage.entity.BaseEntity;
import org.example.hospital_manage.enums.DosageUnit;
import org.example.hospital_manage.enums.DurationUnit;
import org.example.hospital_manage.enums.IntakeTime;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prescription_items")
@Getter
@Setter
public class PrescriptionItem extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id", nullable = false)
    private Prescription prescription;

    @Column(nullable = false,length=100)
    private String medicineName;

    @Column(nullable = false,length = 30)
    private String dosage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private DosageUnit dosageUnit;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "prescription_item_intake_times",
            joinColumns = @JoinColumn(name = "prescription_item_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "intake_time")
    private Set<IntakeTime> intakeTimes = new HashSet<>();

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer duration;

    @Column
    @Enumerated(EnumType.STRING)
    DurationUnit durationUnit;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String instructions;

}

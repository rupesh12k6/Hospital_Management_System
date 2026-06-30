package org.example.hospital_manage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity(name = "doctor_availability")
@Table(  name = "doctor_availability",
        indexes = {
                @Index(name = "idx_availability_doctor", columnList = "doctor_id"),
                @Index(name = "idx_availability_day",columnList = "doctor_id,day_of_week")
        },
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"doctor_id", "day_of_week", "start_time"
                        }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorAvailability {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek dayOfWeek;

    @NotNull
    @Column(nullable = false)
    private LocalTime startTime;

    @NotNull
    @Column(nullable = false)
    private LocalTime endTime;

    @Min(1)
    @Max(200)
    @Column(nullable = false)
    private Integer maxAppointments;

    @Min(5)
    @Max(120)
    @Column(nullable = false)
    private Integer slotDuration;

    @Column(nullable = false)
    private Boolean available = true;

}

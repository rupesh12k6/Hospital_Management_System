package org.example.hospital_manage.entity.clinicalModule;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.hospital_manage.entity.BaseEntity;
import org.example.hospital_manage.entity.Patient;
import org.example.hospital_manage.entity.User;
import org.example.hospital_manage.enums.DocumentType;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Table(
        name = "medical_documents",
        indexes = {
                @Index(name = "idx_document_patient", columnList = "patient_id"),
                @Index(name = "idx_document_record", columnList = "medical_record_id"),
                @Index(name = "idx_document_type", columnList = "document_type")
        }
)
public class MedicalDocument extends BaseEntity{
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="medical_record_id")
    private MedicalRecord medicalRecord;

    @Column(nullable = false, length = 500)
    private String fileUrl;

    @Column(nullable = false)
    private String fileName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentType documentType;

    @Column(nullable = false)
    private LocalDateTime uploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploaded_by")
    private User uploadedBy;

}

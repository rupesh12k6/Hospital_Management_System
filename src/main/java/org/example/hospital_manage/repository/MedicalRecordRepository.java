package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.clinicalModule.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
}

package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.clinicalModule.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
}

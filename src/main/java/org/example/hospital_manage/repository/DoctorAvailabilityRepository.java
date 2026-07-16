package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability,Long> {
}

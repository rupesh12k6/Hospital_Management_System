package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}

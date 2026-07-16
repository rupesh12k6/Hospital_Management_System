package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}

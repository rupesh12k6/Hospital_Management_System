package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionistRepository extends JpaRepository<Receptionist,Long> {
}

package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.billingModule.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}

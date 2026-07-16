package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.billingModule.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}

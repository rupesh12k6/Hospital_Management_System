package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.billingModule.ChargeCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeCatalogRepository extends JpaRepository<ChargeCatalog,Long> {
}

package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

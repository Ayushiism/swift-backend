package com.example.Swift_backend.repository;

import com.example.Swift_backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);
}

package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Admin;
import com.example.Swift_backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin authenticateAdmin(String adminEmail, String adminPassword) {
        return adminRepository.findByAdminEmailAndAdminPassword(adminEmail, adminPassword);
    }
}

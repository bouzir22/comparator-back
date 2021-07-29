package com.example.epi.server.repository;

import com.example.epi.server.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Long> {
  Vendor findByEmail(String email);
}

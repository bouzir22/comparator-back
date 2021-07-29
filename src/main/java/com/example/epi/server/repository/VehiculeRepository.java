package com.example.epi.server.repository;

import com.example.epi.server.model.characteristics.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}

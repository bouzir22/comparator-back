package com.example.epi.server.repository;

import com.example.epi.server.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByEmail(String email);
}

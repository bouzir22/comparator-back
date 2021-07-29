package com.example.epi.server.repository;

import com.example.epi.server.model.characteristics.Telephonie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelephonieRepository extends JpaRepository<Telephonie,Long> {
    List<Telephonie> getByRamAndAndCameraAndEcran(String ram,String camera,String ecran);
}

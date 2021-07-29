package com.example.epi.server.repository;

import com.example.epi.server.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepoistory extends JpaRepository<ImageModel,Long> {
}

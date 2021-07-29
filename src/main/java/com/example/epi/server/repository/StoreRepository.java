package com.example.epi.server.repository;
import com.example.epi.server.model.Pack;
import com.example.epi.server.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
    @Query(value = "select * from store where status =false ",nativeQuery = true)
    public List<Store> getRemaining();

    public List<Store> findByStatusTrue();

    List<Store> findByPack(Pack pack);
}

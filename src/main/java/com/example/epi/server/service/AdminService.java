package com.example.epi.server.service;

import com.example.epi.server.model.Store;
import com.example.epi.server.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminService {
    @Autowired
    private StoreRepository storeRepository;
public void activateStore(Long id)
{ Store store =this.storeRepository.findById(id).get(); store.setDateTime(LocalDateTime.now());store.setStatus(true);this.storeRepository.save(store);}





}

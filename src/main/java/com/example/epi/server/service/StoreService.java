package com.example.epi.server.service;

import com.example.epi.server.model.Pack;
import com.example.epi.server.model.Store;
import com.example.epi.server.model.Vendor;
import com.example.epi.server.repository.StoreRepository;
import com.example.epi.server.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private VendorRepository vendorRepository;
    //creates a store and updates his owner
    public void createStore(Store store,Long id ) {
        store.setVendor(this.vendorRepository.findById(id).get());

        this.storeRepository.save(store);

    }
    public Store getStore(Long id)
    {return this.storeRepository.findById(id).get();}
    public Store getByUserId(Long id){
        return this.vendorRepository.findById(id).get().getStore();
    }

    public List<Store> getAll() {return this.storeRepository.findAll();  }

    public List<Store> getRemaining()
    {return this.storeRepository.getRemaining();}
    public List<Store> storeActivTrue()
    {return this.storeRepository.findByStatusTrue();}


    public void setPack(Long id , String pack)
    {Store store=this.storeRepository.findById(id).get();
    if(pack.equals("basic")) store.setPack(Pack.BASIC);
        if(pack.equals("pro")) store.setPack(Pack.PROFESSIONAL);
        if (pack.equals(("luxury"))) store.setPack(Pack.LUXURY);

this.storeRepository.save(store);
    }

    public List<Store> getBanner() {
        return this.storeRepository.findByPack(Pack.LUXURY);
    }
}

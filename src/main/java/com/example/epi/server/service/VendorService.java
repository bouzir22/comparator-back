package com.example.epi.server.service;

import com.example.epi.server.model.Vendor;
import com.example.epi.server.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAll()
    {return this.vendorRepository.findAll();}
    public Vendor saveVendor(Vendor vendor)
    {return  this.vendorRepository.save(vendor);}
}

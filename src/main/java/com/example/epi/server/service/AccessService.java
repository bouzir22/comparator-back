package com.example.epi.server.service;
import com.example.epi.server.controller.AccessController;
import com.example.epi.server.model.Admin;
import com.example.epi.server.model.Vendor;
import com.example.epi.server.repository.AdminRepository;
import com.example.epi.server.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService{
    @Autowired
private VendorRepository vendorRepository;
    @Autowired
    private AdminRepository adminRepository;

    public Vendor registerVendor(Vendor vendor)     {return this.vendorRepository.save(vendor);}
    public Vendor loginVendor(String email)     {return this.vendorRepository.findByEmail(email) ;}
    public Admin loginAdmin(String email)     {return this.adminRepository.findByEmail(email) ;}
}

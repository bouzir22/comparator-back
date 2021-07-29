package com.example.epi.server.controller;

import com.example.epi.server.model.Vendor;
import com.example.epi.server.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("vendor")

public class VendorController {
    @Autowired
private VendorService vendorService;
    @GetMapping("/all")
public List<Vendor>getAll(){return this.vendorService.getAll();}
@PostMapping("/save")
public  Vendor saveVendor(@RequestBody Vendor vendor){return this.vendorService.saveVendor(vendor);}


}

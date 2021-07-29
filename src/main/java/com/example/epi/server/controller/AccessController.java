package com.example.epi.server.controller;

import com.example.epi.server.model.Admin;
import com.example.epi.server.model.Client;
import com.example.epi.server.model.Vendor;
import com.example.epi.server.repository.ClientRepository;
import com.example.epi.server.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("access")
public class AccessController {
    @Autowired
private AccessService accessService;
    @Autowired
    ClientRepository clientRepository;
@PostMapping("/register")
public Vendor registerVendor(@RequestBody Vendor vendor) {return this.accessService.registerVendor(vendor); }
@GetMapping("/vendor/login/{email}") public Vendor loginVendor(@PathVariable String email){ return this.accessService.loginVendor(email);}
@GetMapping("/admin/login/{email}") public Admin loginAdmin(@PathVariable String email){ return this.accessService.loginAdmin(email);}
    @GetMapping("/client/login/{email}") public Client loginClient(@PathVariable String email){ return this.clientRepository.findByEmail(email);}




























}

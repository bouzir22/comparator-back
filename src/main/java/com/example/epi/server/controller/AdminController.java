package com.example.epi.server.controller;

import com.example.epi.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService ;
    @GetMapping ("/activate/{id}")
    public void activateteStore(@PathVariable("id") Long id){
        this.adminService.activateStore(id);


    }

    }




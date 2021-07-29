package com.example.epi.server.controller;

import com.example.epi.server.model.Client;
import com.example.epi.server.model.Product;
import com.example.epi.server.model.characteristics.Telephonie;
import com.example.epi.server.model.characteristics.Vehicule;
import com.example.epi.server.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
@CrossOrigin("*")
public class ClientController {
  private   String operation;
    @Autowired
    private ClientService clientService;
     @PostMapping("register")
     public Client register(@RequestBody Client client){

         return this.clientService.Register(client);

     }

    @PostMapping("set/telephonie")
    public void setTelephonie(@RequestBody Telephonie telephonie){this.clientService.telephonie=telephonie; this.operation="tel";}
    @PostMapping("set/vehicule")
    public void setVehicule(@RequestBody Vehicule vehicule){this.clientService.vehicule=vehicule;this.operation="veh";}
    @PostMapping("set/product")
    public void setProduct(@RequestBody Product product){this.clientService.product=product; }


        @GetMapping("wish/{id}")
    public void  saveWish(@PathVariable Long id)
        {
            System.out.println("wish");
            this.clientService.saveWish(id,operation);}
}

package com.example.epi.server.service;

import com.example.epi.server.model.Client;
import com.example.epi.server.model.Product;
import com.example.epi.server.model.characteristics.Telephonie;
import com.example.epi.server.model.characteristics.Vehicule;
import com.example.epi.server.repository.ClientRepository;
import com.example.epi.server.repository.ProductRepository;
import com.example.epi.server.repository.TelephonieRepository;
import com.example.epi.server.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
 private ClientRepository clientRepository;
    @Autowired
private TelephonieRepository telephonieRepository;
    @Autowired
private VehiculeRepository vehiculeRepository ;
    @Autowired
private ProductRepository productRepository;

public Product product;
public Telephonie telephonie;
public Vehicule vehicule;

    public List<Product> saveWish(Long id,String operation)
    {   Client c =this.clientRepository.findById(id).get();
        List<Product> old=  c.getWishes();
     if(operation=="tel")   this.product.setTelephonie(this.telephonieRepository.save(telephonie));
        if(operation=="veh")   this.product.setVehicule(this.vehiculeRepository.save(vehicule));

        this.product.setClient(c);
       old.add(this.productRepository.save(this.product));
       c.setWishes(old);
       this.clientRepository.save(c);

return null;
    }

    public Client Register(Client client)
    {return this.clientRepository.save(client);}

}

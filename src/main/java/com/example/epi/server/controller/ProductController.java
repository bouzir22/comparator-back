package com.example.epi.server.controller;
import com.example.epi.server.model.Product;
import com.example.epi.server.model.characteristics.Telephonie;
import com.example.epi.server.model.characteristics.Vehicule;
import com.example.epi.server.repository.ProductRepository;
import com.example.epi.server.repository.StoreRepository;
import com.example.epi.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private StoreRepository storeRepository;

    @PostMapping("/save/tel")
    public void saveTel (@RequestBody Telephonie telephonie){
        System.out.println(telephonie);
        this.productService.telephonie=telephonie;
    }
    @PostMapping("/save/veh")
    public void saveVeh (@RequestBody Vehicule vehicule){
        System.out.println(vehicule);
        this.productService.vehicule=vehicule;

    }


    @PostMapping("/save/{id}/{cat}")
    public void saveProduct (@RequestBody Product product, @PathVariable("id")Long id,@PathVariable("cat") String cat){
        this.productService.addProduct(product,id,cat);
    }
    @GetMapping("/all")
    public List<Product>getAll()
    {return this.productService.getAll();}


@Autowired
private ProductRepository productRepository;
@GetMapping("/get/{sub}")
    public List<Product>getByCategory(@PathVariable String sub)
{
   return this.productRepository.findBySubcategory(sub);}



    @PostMapping("/test")
    public List<Long> getSpecified(@RequestBody Telephonie tel)
    {return  this.productService.getSpecifiedProducts(tel);}

    @GetMapping("get/wishes/{id}")
    public List<Product> getWishes(@PathVariable Long id)
    {return this.productRepository.findWishes(id);}
    @GetMapping("/one/{id}")
    Product getById(@PathVariable Long id)
    {return this.productRepository.findById(id).get();}

    @PostMapping("update/tel/{id}")
    public void updateTelephonie(@PathVariable Long id ,@RequestBody Telephonie telephonie){
    this.productService.updatetelephonie(id,telephonie);


    }

    @PostMapping("update/veh/{id}")
    public void updateVehicule(@PathVariable Long id,@RequestBody Vehicule vehicule){
    this.productService.updateVehicule(id,vehicule);


    }

}


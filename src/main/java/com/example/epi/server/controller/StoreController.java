package com.example.epi.server.controller;

import com.example.epi.server.model.Store;
import com.example.epi.server.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
@CrossOrigin("*")
public class StoreController {
@Autowired
    private StoreService storeService;
 @PostMapping("/create/{id}")
public  void createStore(@RequestBody Store store , @PathVariable("id") Long id){this.storeService.createStore(store,id);}
@GetMapping("/get/{id}")
public Store getStore(@PathVariable Long id){
     return this.storeService.getStore(id);


}
    @GetMapping("/getByUser/{id}")
public Store getStoreByuserId(@PathVariable Long id){return this.storeService.getByUserId(id);}

    @GetMapping("/all")
    public List<Store> getAll()
    {return this.storeService.getAll();}
    @GetMapping("/remaining")
    public List<Store> getRemaining()
    {return this.storeService.getRemaining() ;}

@GetMapping("active") public List<Store> storeActivTrue()
{return this.storeService.storeActivTrue();}


@GetMapping("pack/{pack}/{id}")
        public void setPack(@PathVariable String pack,@PathVariable Long id)
{this.storeService.setPack(id,pack);


}


}

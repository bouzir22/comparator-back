package com.example.epi.server.controller;


import com.example.epi.server.model.ImageModel;
import com.example.epi.server.model.Product;
import com.example.epi.server.model.Store;
import com.example.epi.server.repository.ImageRepoistory;
import com.example.epi.server.repository.ProductRepository;
import com.example.epi.server.scrapers.Item;
import com.example.epi.server.scrapers.category.Automobile;
import com.example.epi.server.scrapers.category.Telephonie;
import com.example.epi.server.service.ProductService;
import com.example.epi.server.service.ScrapingService;
import com.example.epi.server.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class DataController {
    @Autowired
    ScrapingService scrapingService ;
    @Autowired
    private ProductService productService;


    @RequestMapping("scrap/{keyword}")
    public List<Item> scrap(@PathVariable(name = "keyword") String keyword)
    {
        System.out.println("from controller"+this.scrapingService.scrap(keyword));return this.scrapingService.scrap(keyword);}

    @RequestMapping("static/{param}")
    public List<Item>staticScrap(@PathVariable(name = "param") String param)
    {switch (param){

        case "auto":{
            Automobile auto = new Automobile();
            auto.start();
            while (true){if(! auto.isAlive())break;}
            return auto.finalItems;
        }

        case "tel":{
            Telephonie telephonie =new Telephonie();
            telephonie.start();
            while (true){if(! telephonie.isAlive())break;}
            return telephonie.finalItems;}

        default:return null;
    }

    }

    @RequestMapping("products/{keyword}")
    public List<Product>getProductsByKeyword(@PathVariable String keyword){
       return this.productService.getByKeyword(keyword);}
       ///////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    private ImageRepoistory imageRepoistory;
    @PostMapping("/upload")
    public void uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

        System.out.println("Original Image Byte Size - " + file.getBytes().length);
       this.productService.imageModel= new ImageModel(file.getOriginalFilename(), file.getContentType(),file.getBytes());


    }

@Autowired
private StoreService storeService;
    @GetMapping ("/store/banner")
    public List<Store> storeBanner()
    {return this.storeService.getBanner();}



}
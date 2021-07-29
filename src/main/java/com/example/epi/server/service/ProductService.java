package com.example.epi.server.service;
import com.example.epi.server.model.ImageModel;
import com.example.epi.server.model.Product;
import com.example.epi.server.model.Store;
import com.example.epi.server.model.characteristics.Telephonie;
import com.example.epi.server.model.characteristics.Vehicule;
import com.example.epi.server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private TelephonieRepository telephonieRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;
    List<Long> teleponieIds;

public  Telephonie telephonie;  public Vehicule vehicule;
public ImageModel imageModel;
@Autowired
private ImageRepoistory imageRepoistory;


    public void addProduct(Product product,Long idVendor,String cat){

        Store store =   this.vendorRepository.findById(idVendor).get().getStore();
        product.setBoutique(store.getName());
        product.setStore(store);product.setVisible(true);
 if(cat.equals("tel")) product.setTelephonie(this.telephonieRepository.save(telephonie));
 if(cat.equals("veh")) product.setVehicule(this.vehiculeRepository.save(vehicule));

 product.setImageModel(this.imageRepoistory.save(imageModel));
        this.productRepository.save(product);

    }















//old save
public void addProduct(Product product,Long idVendor){

   Store store =   this.vendorRepository.findById(idVendor).get().getStore();
    product.setBoutique(store.getName());
    product.setStore(store);

    this.productRepository.save(product);

}

public List<Product>getAll(){
    //List<Product> p =this.productRepository.findByVisibleTrue();
    //System.out.println(p);

    return this.productRepository.findByVisibleTrue();
}

public List<Product> getByKeyword(String keyword)
{return this.productRepository.getByKeyword(keyword);}


public List<Product> getByCategory(String category){
        return this.productRepository.findBySubcategory(category);
}


public List<Long> getSpecifiedProducts(Telephonie telephonie)
{
List<Long> finalitems =new ArrayList<>();
for(Telephonie tel:this.telephonieRepository.getByRamAndAndCameraAndEcran(telephonie.ram,telephonie.camera,telephonie.ecran))
{
    System.out.println(tel.id);
    finalitems.add(tel.id);

}

/*
   List<Product>products=this.productRepository.findBySubcategory(sub);
    System.out.println(products);
List<Product> finalProducts= products
            .stream().filter(product -> product.getTelephonie().getCamera()==telephonie.camera).collect(Collectors.toList());

*/








/*

for (Product p:products)
{
    System.out.println("first"+p.getTelephonie().getCamera());
    System.out.println("second"+telephonie.getCamera());

    if(p.getTelephonie().getCamera().equals(telephonie.getCamera())
            //&&p.getTelephonie().getEcran()==telephonie.getEcran()&&p.getTelephonie().getRam()==telephonie.getRam()
    ){finalProducts.add(p);


    }


}*/this.teleponieIds=finalitems;
    System.out.println("finalitems"+this.teleponieIds);
    getBycarcs();

return  finalitems;
}

List<Product>getBycarcs()
{int i=0;


{Product p=this.productRepository.findByTelId(new Long(1));++i;
    System.out.println(p);
;}
return null;
}



public void updateVehicule(Long id,Vehicule vehicule){
    Product p=this.productRepository.findById(id).get();
    Long idVeh =p.getVehicule().getId();
    vehicule.setId(idVeh);
    System.out.println(vehicule);
    this.vehiculeRepository.save(vehicule);


}


    public void updatetelephonie(Long id,Telephonie telephonie){
        Product p=this.productRepository.findById(id).get();
       Long idTel =p.getTelephonie().id;
       telephonie.id=idTel;
        System.out.println(telephonie);
       this.telephonieRepository.save(telephonie);

    }



}

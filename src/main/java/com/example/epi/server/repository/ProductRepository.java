package com.example.epi.server.repository;

import com.example.epi.server.model.Product;
import com.example.epi.server.model.characteristics.Telephonie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select * from product",nativeQuery = true)
    List<Product> getAll ();
    @Query(value = "SELECT * FROM Product p WHERE p.name like %?1%", nativeQuery = true)
    List<Product>getByKeyword(String keyword);


    List<Product> findBySubcategory(String subcategory);
    @Query(
            value = "SELECT * FROM product p WHERE p.telephonie_id = ?1 ",
            nativeQuery = true)
    Product findByTelId(Long id);



    @Query(
            value = "SELECT * FROM product p WHERE p.client_id = ?1",
            nativeQuery = true)
   List<Product> findWishes(Long id);

    @Query(
            value = "SELECT * FROM product  WHERE visible= 1",
            nativeQuery = true)
    List<Product> findPoducts();

List<Product>findByVisibleTrue();


}

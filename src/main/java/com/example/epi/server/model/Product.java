package com.example.epi.server.model;


import com.example.epi.server.model.characteristics.Telephonie;
import com.example.epi.server.model.characteristics.Vehicule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private  String name;
private  double price;
private String imageUrl;
private String category;
private String subcategory;
private String characs;
private boolean visible;
//(fetch = FetchType.LAZY)
@OneToOne
private Telephonie telephonie;
@OneToOne
private Vehicule vehicule;

@OneToOne
private ImageModel imageModel;


private String  boutique;

@JsonIgnore
@ManyToOne(fetch = FetchType.LAZY)
private Store store;
    @JsonIgnore
    @ManyToOne
    private Client client;




    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", characs='" + characs + '\'' +
                ", telephonie=" + telephonie +
                ", vehicule=" + vehicule +
                ", boutique='" + boutique + '\'' +
                ", store=" + store +
                '}';
    }
}

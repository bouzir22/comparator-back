package com.example.epi.server.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String category;
//activation-date
private LocalDateTime dateTime;
private boolean status ;
@OneToOne
private Vendor vendor;
    @OneToOne
    private ImageModel imageModel;

@OneToMany(mappedBy = "store",fetch = FetchType.LAZY)
    private List<Product> products;

private Pack pack;

}

package com.example.epi.server.model.characteristics;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String CARROSSERIE;
    public String nbCYLINDRES	;
    public String ENERGIE	;
    public String PUISSANCEFISCALE	;
    public String PUISSANCE ;
    public  String COUPLE	;
    public String CYLINDREE;
    public int min;
    public int max;
    public String  boite;


    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", CARROSSERIE='" + CARROSSERIE + '\'' +
                ", nbCYLINDRES='" + nbCYLINDRES + '\'' +
                ", ENERGIE='" + ENERGIE + '\'' +
                ", PUISSANCEFISCALE='" + PUISSANCEFISCALE + '\'' +
                ", PUISSANCE='" + PUISSANCE + '\'' +
                ", COUPLE='" + COUPLE + '\'' +
                ", CYLINDREE='" + CYLINDREE + '\'' +
                '}';
    }
}

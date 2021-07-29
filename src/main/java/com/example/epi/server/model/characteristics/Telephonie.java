package com.example.epi.server.model.characteristics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telephonie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id ;
    public String ecran;
    public String   ram ;
    public String ROM ;
    public String Processeur ;
    public String  camera ;
    public String  fcamera ;
    public String  Systeme ;
    public String  Batterie;
    public int min;
    public int max;


}

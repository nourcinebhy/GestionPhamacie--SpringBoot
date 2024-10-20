package com.nourcine.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produit")
public class Produit {
    @GeneratedValue
    @Id
    private Long id_p;
    private String nom_p;
    private float price;
    private int qte;
    private String fab_date;
    private String exp_date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "produits")
    private Set<Vente> ventes;
}


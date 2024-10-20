package com.nourcine.backend.dto;

import com.nourcine.backend.entities.Produit;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProduit {
    Long id;
    String nom_p;
    float price;
    int qte;
    String fab_date;
    String exp_date;

    Long categoryId;
    String categoryName;

    public static ResponseProduit makeProduit(Produit produit) {
        return ResponseProduit.builder()
                .id(produit.getId_p())
                .nom_p(produit.getNom_p())
                .price(produit.getPrice())
                .qte(produit.getQte())
                .fab_date(produit.getFab_date())
                .exp_date(produit.getExp_date())
                .categoryId(produit.getCategory().getId())  // Set category id
                .categoryName(produit.getCategory().getName())  // Set category name
                .build();
    }


}

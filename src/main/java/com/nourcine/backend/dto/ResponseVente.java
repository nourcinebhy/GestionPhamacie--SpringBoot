package com.nourcine.backend.dto;

import com.nourcine.backend.entities.Vente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVente {
    Long id_v;
    int qte;
    float total;
    String exp_date;
    String nom_p; // Added field for the name of the produit
    Long produitId; // Added field to store the ID of the produit

    public static ResponseVente makeVente(Vente vente){
        ResponseVente responseVente = ResponseVente.builder()
                .id_v(vente.getId())
                .qte(vente.getQte())

                .exp_date(vente.getCreatedAt().toString()) // Assuming exp_date is the createdAt field
                .build();

        if (vente.getProduits() != null && !vente.getProduits().isEmpty()) {
            responseVente.setNom_p(vente.getProduits().iterator().next().getNom_p()); // Assuming one vente can have one produit for simplicity
            responseVente.setProduitId(vente.getProduits().iterator().next().getId_p());
        }

        return responseVente;
    }
}


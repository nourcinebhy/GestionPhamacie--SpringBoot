package com.nourcine.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestProduit {
    private String nom_p;
    private float price;
    private int qte;
    private String fab_date;
    private String exp_date;


    private Long category_id;
}

package com.nourcine.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestVente {
    private int qte;
    private float total;
    private boolean ordonnace;

    private Long produitId;
}

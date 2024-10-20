package com.nourcine.backend.service;

import com.nourcine.backend.dto.RequestProduit;
import com.nourcine.backend.dto.ResponseProduit;
import com.nourcine.backend.entities.Produit;

import java.util.List;

public interface ProduitService {

    List<ResponseProduit> getAllProduits();
    void createProduit(RequestProduit request);

    boolean deleteProduit(Long id);
    Produit updateProduit(Long id, RequestProduit requestProduit);
    ResponseProduit getProduitById(Long id);


}

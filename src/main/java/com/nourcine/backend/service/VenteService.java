package com.nourcine.backend.service;

import com.nourcine.backend.dto.RequestVente;
import com.nourcine.backend.dto.ResponseVente;
import com.nourcine.backend.entities.Vente;

import java.util.List;

public interface VenteService {
    void createVente(RequestVente requestVente);
    List<ResponseVente> getAllVents();
    boolean deleteVente(Long id);
    Vente updateVente(Long id, RequestVente requestVente);
    ResponseVente getVenteById(Long id);
}

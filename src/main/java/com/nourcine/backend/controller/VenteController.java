package com.nourcine.backend.controller;

import com.nourcine.backend.dto.RequestVente;
import com.nourcine.backend.dto.ResponseVente;
import com.nourcine.backend.entities.Vente;
import com.nourcine.backend.service.VenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ventes")
@RequiredArgsConstructor
public class VenteController  {
    private final VenteService venteService;

    @PostMapping()
    public ResponseEntity<Object> createVente(@RequestBody RequestVente request) {
        venteService.createVente(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vente created successfully.");
    }

    @GetMapping
    public ResponseEntity<List<ResponseVente>> getAllVentes() {
        List<ResponseVente> ventes = venteService.getAllVents();
        return ResponseEntity.ok(ventes);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseVente> getVenteById(@PathVariable Long id) {
        ResponseVente vente = venteService.getVenteById(id);
        if (vente != null) {
            return ResponseEntity.ok(vente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateVente(@PathVariable Long id, @RequestBody RequestVente request) {
        Vente updatedVente = venteService.updateVente(id, request);
        if (updatedVente != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Vente updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteVente(@PathVariable Long id) {
        boolean deleted = venteService.deleteVente(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Vente deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


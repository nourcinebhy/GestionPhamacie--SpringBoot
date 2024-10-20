package com.nourcine.backend.controller;

import com.nourcine.backend.dto.RequestProduit;
import com.nourcine.backend.dto.ResponseProduit;
import com.nourcine.backend.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/produit")
/*@PreAuthorize("hasRole('ADMIN')")*/
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping()
    //@PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Object> createProduit(@RequestBody  RequestProduit request) {
        produitService.createProduit(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message", "save success!"));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateProduit(@PathVariable(name = "id") Long id, @RequestBody @Valid RequestProduit request) {
        produitService.updateProduit(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Collections.singletonMap("message", "update success!"));
    }

    @GetMapping

    public ResponseEntity<List<ResponseProduit>> getAllProduits() {
        List<ResponseProduit> produits = produitService.getAllProduits();
        return ResponseEntity.ok(produits);
    }




    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteProduit(@PathVariable Long id) {
        boolean deleteProduit = produitService.deleteProduit(id);
        if (deleteProduit) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "delete success !!")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message", "user not exist"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseProduit> getProduitById(@PathVariable Long id){
        return ResponseEntity.ok(produitService.getProduitById(id));
    }


}



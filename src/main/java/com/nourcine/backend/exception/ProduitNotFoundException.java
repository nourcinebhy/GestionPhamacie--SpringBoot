package com.nourcine.backend.exception;

public class ProduitNotFoundException extends RuntimeException{

    public ProduitNotFoundException(Long id){
        super("Could not found the produit with id "+ id);
    }
}

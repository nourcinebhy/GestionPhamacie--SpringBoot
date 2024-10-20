package com.nourcine.backend.dto;


public class ProduitDTO {
    private String nom_p;
    private float price;
    private int qte;
    private String fab_date;
    private String exp_date;
    private char description ;

    private Long category_id;

    public String getNom_p() {
        return nom_p;
    }

    public void setNom_p(String nom_p) {
        this.nom_p = nom_p;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getFab_date() {
        return fab_date;
    }

    public void setFab_date(String fab_date) {
        this.fab_date = fab_date;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }





    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }


}

package com.nourcine.backend.serviceImpl;

import com.nourcine.backend.dto.RequestProduit;
import com.nourcine.backend.dto.ResponseProduit;
import com.nourcine.backend.entities.Category;
import com.nourcine.backend.entities.Produit;
import com.nourcine.backend.repository.CategoryRepository;
import com.nourcine.backend.repository.ProduitRepository;
import com.nourcine.backend.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ProduitServiceImp implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ResponseProduit> getAllProduits() {
        List<Produit> produits = produitRepository.findAll();
        List<ResponseProduit> produitFormated = new ArrayList<>();
        for (Produit produit : produits) {
            ResponseProduit prod = ResponseProduit.makeProduit(produit);
            produitFormated.add(prod);
        }
        return produitFormated;
    }
    @Override
    public void createProduit(RequestProduit request) {
        try {
            Category category = categoryRepository.findById(request.getCategory_id())
                    .orElseThrow(() -> new RuntimeException("Category not found with ID: " + request.getCategory_id()));
            Produit produit = Produit.builder()
                    .category(category)
                    .qte(request.getQte())
                    .price(request.getPrice())
                    .nom_p(request.getNom_p())
                    .exp_date(request.getExp_date())
                    .fab_date(request.getFab_date())
                    .build();
            produitRepository.save(produit);
//            Produit produit =new Produit();
//            produit.setNom_p(request.getNom_p());
//            produit.setQte(request.getQte());
//            produit.setPrice(request.getPrice());
//            produit.setExp_date(request.getExp_date());
//            produit.setFab_date(request.getFab_date());
//            produit.setCategory(category);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            throw new RuntimeException("Failed to create product: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteProduit(Long id) {
        if(!produitRepository.existsById(id)){
            return false;
        }
        produitRepository.deleteById(id);
        return true;
    }

    @Override
    public Produit updateProduit(Long id, RequestProduit requestProduit) {
        Produit produit=produitRepository.findById(id).orElseThrow();
        if(requestProduit.getPrice()!=0){
            produit.setPrice(requestProduit.getPrice());
        }
        if (requestProduit.getNom_p()!=null){
            produit.setNom_p(requestProduit.getNom_p());
        }
        if (requestProduit.getQte()!=0){
            produit.setQte(requestProduit.getQte());
        }
        if (requestProduit.getExp_date()!=null){
            produit.setExp_date(requestProduit.getExp_date());
        }
        if (requestProduit.getFab_date()!=null){
            produit.setFab_date(requestProduit.getFab_date());
        }
        return produitRepository.save(produit);
    }

    @Override
    public ResponseProduit getProduitById(Long id) {
        Optional<Produit> produit=produitRepository.findById(id);
        return ResponseProduit.makeProduit(produit.get());
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}

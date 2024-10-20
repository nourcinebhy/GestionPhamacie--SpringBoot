package com.nourcine.backend.serviceImpl;

import com.nourcine.backend.dto.RequestVente;
import com.nourcine.backend.dto.ResponseVente;
import com.nourcine.backend.entities.Produit;
import com.nourcine.backend.entities.Vente;
import com.nourcine.backend.repository.ProduitRepository;
import com.nourcine.backend.repository.VenteRepository;
import com.nourcine.backend.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenteServiceImpl implements VenteService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private VenteRepository venteRepository;



    @Override
    public void createVente(RequestVente requestVente) {
        // Fetch the produit associated with this vente
        Produit produit = produitRepository.findById(requestVente.getProduitId()).orElse(null);
        if (produit != null) {
            // Create a new vente entity
            Vente vente = new Vente();
            vente.setQte(requestVente.getQte());

            // Set other fields as needed

            // Add the produit to the vente's Set<Produit>
            vente.getProduits().add(produit);

            // Save the vente entity
            venteRepository.save(vente);
        } else {
            // Handle the case where the produit is not found
        }
    }



    @Override
    public List<ResponseVente> getAllVents() {
        // Retrieve all Vente entities from the repository
        List<Vente> ventes = venteRepository.findAll();
        // Convert each Vente entity to ResponseVente DTO
        return ventes.stream()
                .map(ResponseVente::makeVente)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteVente(Long id) {
        // Check if the vente exists
        if (venteRepository.existsById(id)) {
            venteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Vente updateVente(Long id, RequestVente requestVente) {
        // Fetch the vente from repository
        Vente vente = venteRepository.findById(id).orElse(null);

        if (vente != null) {
            // Update the fields based on requestVente
            vente.setQte(requestVente.getQte());
          Produit p=  produitRepository.findById(requestVente.getProduitId()).get();
          p.setQte(p.getQte()-requestVente.getQte());
          produitRepository.save(p);
            // Assuming exp_date is not updatable
            // Assuming ordonnace is not updatable
            // Save the updated vente
            return venteRepository.save(vente);
        }
        return null;
    }

    @Override
    public ResponseVente getVenteById(Long id) {
        // Fetch the vente from repository
        Vente vente = venteRepository.findById(id).orElse(null);
        if (vente != null) {
            // Convert Vente entity to ResponseVente DTO
            return ResponseVente.makeVente(vente);
        }
        return null;
    }
}

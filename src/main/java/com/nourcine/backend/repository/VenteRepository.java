package com.nourcine.backend.repository;

import com.nourcine.backend.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Long> {
}

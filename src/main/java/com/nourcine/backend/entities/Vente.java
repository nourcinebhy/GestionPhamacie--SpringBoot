package com.nourcine.backend.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vente")
public class Vente {
    @GeneratedValue
    @Id
    private Long id;
    private int qte;

    @CreationTimestamp
    private Instant createdAt;
    private boolean ordonnace;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "vente_produit",
            joinColumns = @JoinColumn(name = "vente_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private Set<Produit> produits = new HashSet<>();
}

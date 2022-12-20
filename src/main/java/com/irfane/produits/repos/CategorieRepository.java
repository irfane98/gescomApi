package com.irfane.produits.repos;

import com.irfane.produits.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie , Long> {
}

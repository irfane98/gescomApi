package com.irfane.produits.restController;

import com.irfane.produits.entities.Produit;
import com.irfane.produits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin //pour la securite
public class ProduitRestController {
    @Autowired
    ProduitService produitService;
    @RequestMapping(method = RequestMethod.GET)// pour afficher tous les produits
   public  List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET) // pour afficher un produit par son id
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    @RequestMapping(method = RequestMethod.POST) // pour creer un nouveau produit
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    @RequestMapping(method = RequestMethod.PUT) //pour mettre a jour un produit
    public Produit updateProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE) // pour supprimer un produit
    public void deleteProduit(@PathVariable("id") Long id)
    {
        produitService.deleteProduitById(id);
    }
    @RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)//retourne tous les produits d'une categorie donnée
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

}

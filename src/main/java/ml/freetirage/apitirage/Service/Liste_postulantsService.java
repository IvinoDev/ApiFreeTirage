package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Liste_postulants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Liste_postulantsService {

    // Création d'une Liste de postulants
    Liste_postulants creerListe(Liste_postulants liste_postulants);

    // Mise à jour de la Liste de postulants
    Liste_postulants updateListe(Liste_postulants liste_postulants);

    // Retrouver une liste à travers son libellé
    Liste_postulants retrouveParLibelle(String libelle);

    //List<Liste_postulants> afficher();
    Iterable<Object[]> afficher();

    Iterable<Object[]> nombreListe();

    Liste_postulants ajoutListExist(Liste_postulants list_postulants, String libelle, int nombre);

    List<Liste_postulants> getAllLists();
}

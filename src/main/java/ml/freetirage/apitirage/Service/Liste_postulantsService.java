package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Liste_postulants;

import java.util.List;

public interface Liste_postulantsService {
    Liste_postulants CreerListe(Liste_postulants liste_postulants);
    List<Liste_postulants> AfficherListe();
}

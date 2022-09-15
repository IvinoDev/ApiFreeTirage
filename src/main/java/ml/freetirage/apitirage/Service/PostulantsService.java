package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Liste_postulants;
import ml.freetirage.apitirage.Model.Postulants;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostulantsService {
    // Création d'un postulant

    Postulants creerPostulants(Postulants postulants);

    // Enregistrement de l'ensemble des postulants
    List<Postulants> saveList(List<Postulants> postulants);

    Postulants RetrouveParMail(String email);

    // methode qui retourne une liste de manière aléatoire
    List<Postulants> listeAleatoire(int nombre);

    // trirage aléatoire
    List<Postulants> tirage(List<Postulants> list, int nombre, Liste_postulants listepostulants,String libelleTirage);




}

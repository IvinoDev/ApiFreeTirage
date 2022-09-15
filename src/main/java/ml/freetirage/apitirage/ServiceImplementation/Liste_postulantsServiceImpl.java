package ml.freetirage.apitirage.ServiceImplementation;

import ml.freetirage.apitirage.Model.Liste_postulants;
import ml.freetirage.apitirage.Model.Postulants;
import ml.freetirage.apitirage.Model.Postulants_Tires;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Repository.Liste_postulantsRepository;
import ml.freetirage.apitirage.Repository.PostulantsRepository;
import ml.freetirage.apitirage.Repository.Postulants_TiresRepository;
import ml.freetirage.apitirage.Repository.TirageRepository;
import ml.freetirage.apitirage.Service.Liste_postulantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class Liste_postulantsServiceImpl implements Liste_postulantsService {
    @Autowired
    Liste_postulantsRepository repos;

    @Autowired
    PostulantsRepository postulantsRepository;

    @Autowired
    TirageRepository tirageRepository;

    @Autowired
    Postulants_TiresRepository postulants_tiresRepository;

    @Override
    public Liste_postulants creerListe(Liste_postulants liste_postulants) {
        // TODO Auto-generated method stub
        return repos.save(liste_postulants);
    }

    @Override
    public Liste_postulants ajoutListExist(Liste_postulants list_postulants, String libelle, int nombre) {
        Liste_postulants lp = repos.findByLibelle(libelle);
//        list_postulants = lp;
        repos.save(list_postulants);
        //Fonction pour récuperer tous les postulants de la liste d'en haut
        List<Postulants> postulants = postulantsRepository.findByLp(lp);
        System.out.println(postulants.size());
        Random rd = new Random();
        List<Integer> listId = new ArrayList<>();
        List<Postulants> liste_postulants = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            //retourne un nombre aléatoire en fonction de la taille du tableau
            Integer idChoisi = rd.nextInt(postulants.size());

            // ajout a la liste des ids
            listId.add(idChoisi);
            // ajout du postulant dans la liste de postulant trié
            liste_postulants.add(postulants.get(idChoisi));
            postulants.remove(postulants.get(idChoisi));
        }

            // creation du tirage
            Tirage tirage = new Tirage();
            tirage.setDate(new Date());
            tirage.setNPTire(nombre);
            tirage.setLibelle("Tirage " + list_postulants.getLibelle());

            //Attribution de la clé de la liste au tirage
            tirage.setListePostulants(list_postulants);

            // enregistrement du tirage
            Tirage tirageSave = tirageRepository.save(tirage);


            System.out.println(liste_postulants.size());
            for (int i = 0; i < liste_postulants.size(); i++) {
                Postulants_Tires postulants_tires = new Postulants_Tires();
                postulants_tires.setTirage(tirageSave);
                postulants_tires.setNom(liste_postulants.get(i).getNom());
                postulants_tires.setPrenom(liste_postulants.get(i).getPrenom());
                postulants_tires.setNumero(liste_postulants.get(i).getNumero());
                postulants_tires.setEmail(liste_postulants.get(i).getEmail());


                postulants_tiresRepository.save(postulants_tires);

            }
            return lp;

    }

    @Override
    public Liste_postulants retrouveParLibelle(String libelle) {
        // TODO Auto-generated method stub
        return repos.findByLibelle(libelle);
    }

    @Override
    public List<Liste_postulants> getAllLists() {
        return repos.findAll();
    }

    @Override
    public Iterable<Object[]> afficher() {
        return repos.ToutesListe();
    }

    @Override
    public Iterable<Object[]> nombreListe() {
        return repos.NombreListe();
    }
    /*@Override
    public List<Liste_postulants> afficher() {
        return repos.findAll();
    }*/

    @Override
    public Liste_postulants updateListe(Liste_postulants liste_postulants) {
        // TODO Auto-generated method stub
        return repos.save(liste_postulants);
    }

}

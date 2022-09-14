package ml.freetirage.apitirage.ServiceImplementation;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.Liste_postulants;
import ml.freetirage.apitirage.Model.Postulants;
import ml.freetirage.apitirage.Model.Postulants_Tires;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Repository.PostulantsRepository;
import ml.freetirage.apitirage.Repository.Postulants_TiresRepository;
import ml.freetirage.apitirage.Repository.TirageRepository;
import ml.freetirage.apitirage.Service.PostulantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

    @Service
    @AllArgsConstructor
    public class PostulantsServiceImpl implements PostulantsService {

        @Autowired
        PostulantsRepository repos;

        @Autowired
        TirageRepository tirageRepos;

        @Autowired
        Postulants_TiresRepository ptRepos;
        @Override
        public Postulants creerPostulants(Postulants postulants) {
            return repos.save(postulants);
        }

        @Override
        public List<Postulants> saveList(List<Postulants> postulants) {
            for (Postulants p : postulants) {
                if (repos.findByEmail(p.getEmail()) == null) {
                    repos.save(p);
                }

            }
            return postulants;
        }

        @Override
        public Postulants RetrouveParMail(String email) {
            // TODO Auto-generated method stub
            return repos.findByEmail(email);
        }

        @Override
        public List<Postulants> listeAleatoire(int nombre) {
            // TODO Auto-generated method stub
            return repos.Aleatoire(nombre);
        }

        @Override
        public List<Postulants> tirage(List<Postulants> list, int nombre, Liste_postulants listepostulants) {
            // Declaration d'une liste qui va retourner les postulants
            List<Postulants> liste_postulants = new ArrayList<>();
            System.out.println(list.size());
            // récuperation du nombre de postulants requis

            // creation d'une variable de type random
            Random rd = new Random();
            // une variable qui va contenir la liste des ids selectionnés
            List<Integer> listId = new ArrayList<>();
            for (int i = 0; i < nombre; i++) {
                //retourne un nombre aléatoire en fonction de la taille du tableau
                Integer idChoisi = rd.nextInt(list.size());

                /*if (idCoisi == 0 || listId.contains(idCoisi)) {
                    idCoisi = rd.nextInt(list.size());
                }*/
                // ajout a la liste des ids
                listId.add(idChoisi);
                // ajout du postulant dans la liste de postulant trié
                liste_postulants.add(list.get(idChoisi));
                list.remove(list.get(idChoisi));

            }

            // creation du tirage
            Tirage tirage = new Tirage();
            tirage.setDate(new Date());
            tirage.setLibelle("Tirage " +listepostulants.getLibelle());

            //Attribution de la clé de la liste au tirage
            tirage.setListe_postulants(listepostulants);

            // enregistrement du tirage
            Tirage tirageSave = tirageRepos.save(tirage);


            System.out.println(liste_postulants.size());
            for(int i=0;i<liste_postulants.size();i++){
                Postulants_Tires postulants_tires=new Postulants_Tires();
                postulants_tires.setTirage(tirageSave);
                postulants_tires.setNom(liste_postulants.get(i).getNom());
                postulants_tires.setPrenom(liste_postulants.get(i).getPrenom());
                postulants_tires.setNumero(liste_postulants.get(i).getNumero());
                postulants_tires.setEmail(liste_postulants.get(i).getEmail());


                ptRepos.save(postulants_tires);
            }

            // Retour de la liste créer
            return liste_postulants;

        }


    }




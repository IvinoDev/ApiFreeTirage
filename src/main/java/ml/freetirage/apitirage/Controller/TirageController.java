package ml.freetirage.apitirage.Controller;

import ml.freetirage.apitirage.Message.ResponseMessage;

import ml.freetirage.apitirage.Model.Liste_postulants;
import ml.freetirage.apitirage.Model.Postulants_Tires;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Repository.Liste_postulantsRepository;
import ml.freetirage.apitirage.Repository.TirageRepository;
import ml.freetirage.apitirage.Service.Liste_postulantsService;
import ml.freetirage.apitirage.Service.PostulantsService;
import ml.freetirage.apitirage.Service.Postulants_TiresService;
import ml.freetirage.apitirage.Service.TirageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tirage")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TirageController {
    @Autowired
    TirageService service;

    @Autowired
    Liste_postulantsService liste_postulantsService;

    @Autowired
    PostulantsService postulantsService;
    @Autowired
    Postulants_TiresService ptservice;

    @Autowired
    TirageRepository tirageRepository;

    @Autowired
    Liste_postulantsRepository liste_postulantsRepository;

    @GetMapping("/afficher")
    public Iterable<Object[]> getTousTirages(){
        return service.afficherTirage();
    }

    @GetMapping("/nombre")
    public Iterable<Object[]> getNombreListe(){
        return service.nombreTirage();
    }
    @GetMapping("/lister")
    public List<Postulants_Tires> lister() {
        return ptservice.lister();
    }
    @GetMapping("/totaltirageSurList/{idListPost}")
    public Long nbreTirageSurUneListe(@PathVariable Long idListPost) {
        return service.nbreTirageSurUneListe(idListPost);
    }

    @GetMapping("/nombre_pt/{id_tirage}")
    public Long getNombrePT(@PathVariable Long id_tirage){
        return service.nombrePT(id_tirage);
    }

    @GetMapping("/liste/{id}")
    public List<Tirage> findByList (@PathVariable Long id) {
        Liste_postulants liste_postulants = liste_postulantsRepository.findById(id).get();
        return tirageRepository.findByListePostulants(liste_postulants);
    }

    // Création d'un tirage
    @GetMapping("/afficher/{id_tirage}")
    public ResponseEntity<Object> afficher(@PathVariable(value = "id_tirage") Long id_tirage) {
        Tirage T =service.getTirageById(id_tirage);

       // Liste_postulants liste_postulants = liste_postulantsService.retrouveParLibelle(libelle);
        if (T != null) {
            List<Postulants_Tires> postulants_tires = ptservice.findByTirage(T);

            //postulantsService.supprimer(postulants_tires.get());
            // attribution du tirage
            return ResponseMessage.generateResponse("La liste des postulants selectionnées", HttpStatus.OK, postulants_tires);

        } else {
            return ResponseMessage.generateResponse("Erreur, action impossible",
                    HttpStatus.NOT_FOUND, null);
        }

    }
}

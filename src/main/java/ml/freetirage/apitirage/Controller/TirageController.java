package ml.freetirage.apitirage.Controller;

import Message.ResponseMessage;
import ml.freetirage.apitirage.Model.Liste_postulants;
import ml.freetirage.apitirage.Model.Postulants;
import ml.freetirage.apitirage.Service.Liste_postulantsService;
import ml.freetirage.apitirage.Service.PostulantsService;
import ml.freetirage.apitirage.Service.TirageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/tirage")
@Controller
public class TirageController {
    @Autowired
    TirageService service;

    @Autowired
    Liste_postulantsService liste_postulantsService;

    @Autowired
    PostulantsService postulantsService;

    // Création d'un tirage
    @GetMapping("creer/{libelle}/{nombre}")
    public ResponseEntity<Object> creerListe(@PathVariable(value = "libelle") String libelle,
                                              @PathVariable(value = "nombre") Integer nombre) {

        Liste_postulants liste_postulants = liste_postulantsService.retrouveParLibelle(libelle);
        if (liste_postulants != null) {
            List<Postulants> postulants = postulantsService.tirage(liste_postulants.getPostulants(), nombre,liste_postulants);

            // attribution du tirage
            return ResponseMessage.generateResponse("Tirage effectué", HttpStatus.OK, postulants);

        } else {
            return ResponseMessage.generateResponse("Erreur, cette liste n'existe pas dans la base de donnée",
                    HttpStatus.NOT_FOUND, null);
        }

    }
}

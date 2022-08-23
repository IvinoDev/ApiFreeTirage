package ml.freetirage.apitirage.Controller;

import Message.ResponseMessage;
import ml.freetirage.apitirage.Model.Liste_postulants;
import ml.freetirage.apitirage.Model.Postulants;
import ml.freetirage.apitirage.Model.Postulants_Tires;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Service.Liste_postulantsService;
import ml.freetirage.apitirage.Service.PostulantsService;
import ml.freetirage.apitirage.Service.Postulants_TiresService;
import ml.freetirage.apitirage.Service.TirageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    Postulants_TiresService ptservice;

    //Ancien
    @GetMapping("afficher/{id_tirage}")
    public ResponseEntity<Object> afficher(@PathVariable(value = "id_tirage") Long id_tirage) {

        Tirage T = service.getTirageById(id_tirage);


        //Postulants_Tires postulants_tires = ptservice.retrouveParLibelle(libelle);
        if (T != null) {
            List<Postulants_Tires> postulants_tires = ptservice.findByTirage(T);
            //List<Postulants_Tires> postulants = ptservice.tirage(postulants_tires.getTirage(), id_tirage,postulants_tires);

            // attribution du tirage
            return ResponseMessage.generateResponse("Les personnes selectionnées lors de ce tirage", HttpStatus.OK, postulants_tires);

        } else {
            return ResponseMessage.generateResponse("Erreur, action impossible.",
                    HttpStatus.NOT_FOUND, null);
        }

    }

    // Afficher les postulants tirés lors d'un n tirage
   /* @GetMapping("/afficher")
    public List<Postulants_Tires> postulants_tires() {
        return ptservice.postulants_tires();
    }*/

}

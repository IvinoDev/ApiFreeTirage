package ml.freetirage.apitirage.Controller;

import Message.ResponseMessage;
import ml.freetirage.apitirage.Importation.ConfigExcel;
import ml.freetirage.apitirage.Model.Liste_postulants;
import ml.freetirage.apitirage.Model.Postulants;
import ml.freetirage.apitirage.Service.Liste_postulantsService;
import ml.freetirage.apitirage.Service.PostulantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RequestMapping("/liste_postulants")
@Controller
public class Liste_postulantsController {

    @Autowired
    Liste_postulantsService service;

    @Autowired
    PostulantsService postulantsService;

    // Création d'une liste
    @PostMapping("/creer/{libelle}/{nombre}")
    public ResponseEntity<Object> creerListe(@RequestParam("file") MultipartFile file,
                                             @PathVariable(value = "libelle") String libelle,
                                             @PathVariable(value = "nombre") Integer nombre)
            throws IOException {

        // on verifie d'abord si le fichier fornit est de type Excel
        if (ConfigExcel.verification(file)) {
            // vérification de la présence d'une liste dans la BDD
            Liste_postulants liste_postulants = service.retrouveParLibelle(libelle);
            if (liste_postulants == null) {
                // S'il n'en existe aucune, on la créee
                Liste_postulants lp = new Liste_postulants();
                lp.setDate(new Date());

                lp.setLibelle(libelle);
                //Création de la liste

                Liste_postulants lpsave = service.creerListe(lp);

                // après la creation de cette liste, on procède à l'enregistrements des postulants qui sont dans le
                // fichier Excel.
                // On recupère d'abord les postulants
                List<Postulants> postulants = ConfigExcel.postulantsExcel(file);

                //assert postulants != null;
                for (Postulants p : postulants) {

                    p.setListe_postulants(lpsave);
                    postulantsService.creerPostulants(p);


                }

                return ResponseMessage.generateResponse("Tirage effectué", HttpStatus.OK,
                        postulantsService.tirage(postulants, nombre,lpsave));

            } else {
                // Au cas ou il existe une liste avec le même libellé
                return ResponseMessage.generateResponse("La liste existe déjà.", HttpStatus.ALREADY_REPORTED, null);
            }

        } else {
            // Si le fichier fournit n'est pas au format Excel
            return ResponseMessage.generateResponse("Veuiller fournir un fichier au format Excel", HttpStatus.BAD_REQUEST, null);

        }

    }
}

package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Service.PostulantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/Postulants")
public class PostulantsController {
    @Autowired
    final private PostulantsService postulants;

    @PostMapping("/Ajouter_postulant")
        public void AjouterPostulants() {
            postulants.AjouterPostulant();
        }


}

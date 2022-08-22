package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Tirage;
import org.springframework.stereotype.Service;

public interface TirageService {
    // Création d'un Tirage
    Tirage creerTirage(Tirage tirage);

    // Modification d'un tirage
    Tirage modifierTirage(Tirage tirage);

}

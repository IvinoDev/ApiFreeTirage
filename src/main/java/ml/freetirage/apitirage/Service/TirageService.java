package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Tirage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TirageService {
    // Création d'un Tirage
    Tirage creerTirage(Tirage tirage);

    // Modification d'un tirage
    Tirage modifierTirage(Tirage tirage);

    Tirage getTirageById(long id);

    Long nombrePT(Long id_tirage);

    List<Object> AfficherDetailsTirage();

    Iterable<Object[]> afficherTirage();

    Iterable<Object[]> nombreTirage();


}


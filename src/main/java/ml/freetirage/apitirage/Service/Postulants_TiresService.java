package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Postulants_Tires;

import java.util.List;

public interface Postulants_TiresService {
    Postulants_Tires CreerPostulantTire();
    List<Postulants_Tires> AfficherPostulantTire();
}

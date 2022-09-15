package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Postulants_Tires;
import ml.freetirage.apitirage.Model.Tirage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Postulants_TiresService {
    Postulants_Tires creerPostulantTire(Postulants_Tires postulants_tires);
    List<Postulants_Tires> postulants_tires();

    List<Postulants_Tires> findByTirage(Tirage t);
    List<Postulants_Tires>lister();


}

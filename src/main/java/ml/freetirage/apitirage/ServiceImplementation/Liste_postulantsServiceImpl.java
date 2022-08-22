package ml.freetirage.apitirage.ServiceImplementation;

import ml.freetirage.apitirage.Model.Liste_postulants;
import ml.freetirage.apitirage.Repository.Liste_postulantsRepository;
import ml.freetirage.apitirage.Service.Liste_postulantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Liste_postulantsServiceImpl implements Liste_postulantsService {
    @Autowired
    Liste_postulantsRepository repos;

    @Override
    public Liste_postulants creerListe(Liste_postulants liste_postulants) {
        // TODO Auto-generated method stub
        return repos.save(liste_postulants);
    }

    @Override
    public Liste_postulants retrouveParLibelle(String libelle) {
        // TODO Auto-generated method stub
        return repos.findByLibelle(libelle);
    }

    @Override
    public Liste_postulants updateListe(Liste_postulants liste_postulants) {
        // TODO Auto-generated method stub
        return repos.save(liste_postulants);
    }

}

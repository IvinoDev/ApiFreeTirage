package ml.freetirage.apitirage.ServiceImplementation;

import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Repository.TirageRepository;
import ml.freetirage.apitirage.Service.TirageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TirageServiceImpl implements TirageService {
    @Autowired
    TirageRepository repos;


    @Override
    public Tirage creerTirage(Tirage tirage) {
        return repos.save(tirage);
    }

    @Override
    public Tirage modifierTirage(Tirage tirage) {
        return repos.save(tirage);
    }

    @Override
    public Tirage getTirageById(long id) {
        return repos.findById(id).orElseThrow();
    }

    @Override
    public Iterable<Object[]> afficherTirage() {
        return repos.TousTirages();
    }

    @Override
    public Iterable<Object[]> nombreTirage() {
        return repos.NombreTirage();
    }

    @Override
    public Long nbreTirageSurUneListe(Long idListPost) {
        return repos.nbreTirageSurUneListe(idListPost);
    }
}

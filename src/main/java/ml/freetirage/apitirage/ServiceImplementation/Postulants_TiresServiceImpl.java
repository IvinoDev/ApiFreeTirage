package ml.freetirage.apitirage.ServiceImplementation;

import ml.freetirage.apitirage.Model.Postulants_Tires;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Repository.Postulants_TiresRepository;
import ml.freetirage.apitirage.Service.Postulants_TiresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Postulants_TiresServiceImpl implements Postulants_TiresService {
        @Autowired
        Postulants_TiresRepository repos;

        @Override
        public Postulants_Tires creerPostulantTire(Postulants_Tires postulants_tires) {
            // TODO Auto-generated method stub
            return repos.save(postulants_tires);
        }

        @Override
        public List<Postulants_Tires> postulants_tires() {
                return repos.findAll();
        }

        @Override
        public List<Postulants_Tires> findByTirage(Tirage tirage) {
                return repos.findByTirage(tirage);
        }




}


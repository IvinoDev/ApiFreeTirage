package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Liste_postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Liste_postulantsRepository extends JpaRepository<Liste_postulants, Long>{
    Liste_postulants findByLibelle(String libelle);
}

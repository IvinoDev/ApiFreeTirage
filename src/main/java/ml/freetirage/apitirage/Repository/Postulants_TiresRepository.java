package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Postulants_Tires;
import ml.freetirage.apitirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Postulants_TiresRepository extends JpaRepository<Postulants_Tires, Long> {

    List<Postulants_Tires> findByTirage(Tirage tirage);
}

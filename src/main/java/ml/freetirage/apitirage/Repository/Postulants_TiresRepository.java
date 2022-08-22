package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Postulants_Tires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Postulants_TiresRepository extends JpaRepository<Postulants_Tires, Long> {

}

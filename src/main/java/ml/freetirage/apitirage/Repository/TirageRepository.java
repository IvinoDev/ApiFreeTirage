package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TirageRepository extends JpaRepository<Tirage, Long> {
}

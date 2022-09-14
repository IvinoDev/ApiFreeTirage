package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TirageRepository extends JpaRepository<Tirage, Long> {

    //Methode pour afficher tous les tirages existants
    @Query(value = "SELECT * FROM tirage", nativeQuery = true)
    Iterable<Object[]> TousTirages();

    //Fonction pour compter l'ensemble des tirages existants
    @Query(value = "SELECT COUNT(*) FROM tirage", nativeQuery = true)
    Iterable<Object[]> NombreTirage();
}

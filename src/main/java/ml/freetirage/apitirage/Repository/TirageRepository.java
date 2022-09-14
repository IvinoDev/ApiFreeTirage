package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TirageRepository extends JpaRepository<Tirage, Long> {

    @Query(value = "SELECT DISTINCT tirage.nptire, tirage.date, tirage.libelle_tirage FROM tirage,liste_postulants WHERE  tirage.id_liste_postulants=?", nativeQuery = true);
    List<Object> DetailsTirage();


    //Methode pour afficher tous les tirages existants
    @Query(value = "SELECT * FROM tirage", nativeQuery = true)
    Iterable<Object[]> TousTirages();

    //Fonction pour compter l'ensemble des tirages existants
    @Query(value = "SELECT COUNT(*) FROM tirage", nativeQuery = true)
    Iterable<Object[]> NombreTirage();

    @Query(value = "SELECT COUNT(id_tirage) FROM postulants_tires WHERE postulants_tires.id_tirage=:id_tirage", nativeQuery = true)
    Long nombrePT(Long id_tirage);


}

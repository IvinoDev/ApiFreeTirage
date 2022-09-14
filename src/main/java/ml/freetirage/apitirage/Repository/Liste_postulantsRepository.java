package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Liste_postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Liste_postulantsRepository extends JpaRepository<Liste_postulants, Long>{

    Liste_postulants findByLibelle(String libelle);

    //Fonction pour afficher toutes les listes existantes
    @Query(value = "SELECT * FROM liste_postulants", nativeQuery = true)
    Iterable<Object[]> ToutesListe();

    //Fonction pour compter l'ensemble des listes existantes
    @Query(value = "SELECT COUNT(*) FROM liste_postulants", nativeQuery = true)
    Iterable<Object[]> NombreListe();
}

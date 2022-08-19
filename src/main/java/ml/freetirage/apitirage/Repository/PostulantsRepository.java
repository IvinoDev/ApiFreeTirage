package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PostulantsRepository extends JpaRepository<Postulants, Long> {
    @Modifying
    @Transactional
    @Query(value ="insert into Postulants (nom_postulant, prenom_postulant, numero_postulant, mail_postulant) value(?, ?, ?, ?);" ,nativeQuery = true)
    int Inserer(String nom_postulant, String prenom_postulant, String numero_postulant, String mail_postulant);
}


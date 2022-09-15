package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Liste_postulants;
import ml.freetirage.apitirage.Model.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostulantsRepository extends JpaRepository<Postulants, Long> {
    Postulants findByEmail(String email);

    @Query(value = "SELECT * FROM user ORDER BY RAND() LIMIT : nombre", nativeQuery = true)
    List<Postulants> Aleatoire(@Param("nombre") Integer nombre);

    List<Postulants> findByLp(Liste_postulants liste_postulants);

}


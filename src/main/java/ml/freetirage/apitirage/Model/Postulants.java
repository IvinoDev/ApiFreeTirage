package ml.freetirage.apitirage.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "postulants")
public class Postulants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postulant")
    private Long id;
    @Column(name = "nom_postulant")
    private String nom;
    @Column(name = "prenom_postulant")
    private String prenom;
    @Column(name = "numero_postulant")
    private String numero;

    @Column(name = "email_postulant")
    private String email;

    @ManyToOne
   private Liste_postulants lp;
}

    //@JsonIgnore

/*@ManyToMany(mappedBy = "postulants")
    List<Liste_postulants> liste_postulants = new ArrayList<>();*//*


    */
/* @OneToMany
    @JoinColumn(name="liste_postulants", referencedColumnName = "id_list_postulants")
    private Liste_postulants liste_postulants; */






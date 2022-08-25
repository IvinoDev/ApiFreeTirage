package ml.freetirage.apitirage.Model;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Table(name = "postulants_tires")
public class Postulants_Tires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nom_postulant")
    private String nom;
    @Column(name = "prenom_postulant")
    private String prenom;
    @Column(name = "numero_postulant")
    private String numero;
    @Column(name = "email_postulant")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_tirage")
    Tirage tirage;

}


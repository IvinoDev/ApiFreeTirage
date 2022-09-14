package ml.freetirage.apitirage.Model;


import lombok.*;

import javax.persistence.*;

import java.util.Date;


@Entity
@Data
@Table(name="Tirage")
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tirage")
    private Long id;

    @Column(name = "libelle_tirage", unique = true)
    private String libelle;
    @Column(name = "date")
    private Date date;

    private int NPTire;
    @ManyToOne
    @JoinColumn(name = "id_liste_postulants")
    Liste_postulants liste_postulants;



}

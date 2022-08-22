package ml.freetirage.apitirage.Model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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



    /*@ManyToOne
    @JoinColumn(name = "id_liste_postulants")
    private Liste_postulants liste_postulants; */
    @OneToOne
    @JoinColumn(name = "id_liste_postulants")
    private Liste_postulants liste_postulants;


    @OneToMany(mappedBy = "tirage")
    List<Postulants_Tires> postulants_Tires = new ArrayList<>();
}

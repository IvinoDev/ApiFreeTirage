package ml.freetirage.apitirage.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "liste_postulants")
public class Liste_postulants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liste_postulants")
    private Long id;
    @Column(name = "libelle_postulants")
    private String libelle;
    @Column(name = "date_postulants")
    private Date date;

    @JsonIgnore
    @OneToMany
    List<Postulants> postulants = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "liste_postulants")
    private Tirage tirage;


    /*@ManyToMany
    @JoinTable(name = "Liste_postulants",
            joinColumns = {
                    @JoinColumn(name = "id_liste_postulants")},
            inverseJoinColumns = {@JoinColumn(name = "id_postulant")
            }
    ) */

    //List<Postulants> postulants = new ArrayList<>();

    /*@OneToMany(mappedBy = "liste_postulants")
    List<Tirage> tirages = new ArrayList<>();*/

}
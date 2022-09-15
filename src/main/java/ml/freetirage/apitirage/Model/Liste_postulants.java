package ml.freetirage.apitirage.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
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
    @OneToMany(mappedBy = "liste_postulants")
    List<Postulants> postulants = new ArrayList<>();
}

    /*@ManyToMany
    @JoinTable(name = "Liste_postulants",
            joinColumns = {
                    @JoinColumn(name = "id_liste_postulants")},
            inverseJoinColumns = {@JoinColumn(name = "id_postulant")
            }
    )


     */


    /*@OneToMany(mappedBy = "liste_postulants")
    List<Tirage> tirages = new ArrayList<>();*/

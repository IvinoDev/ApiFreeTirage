package ml.freetirage.apitirage.Model;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;





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
}

    /*@ManyToMany
    @JoinTable(name = "Liste_postulants",
            joinColumns = {
                    @JoinColumn(name = "id_liste_postulants")},
            inverseJoinColumns = {@JoinColumn(name = "id_postulant")
            }
    )

    //List<Postulants> postulants = new ArrayList<>();

    /*@OneToMany(mappedBy = "liste_postulants")
    List<Tirage> tirages = new ArrayList<>();*/

package ml.freetirage.apitirage.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "liste_postulants")
public class Liste_postulants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_list_postulants")
    private Long id;
    @Column(name = "libelle_postulants")
    private String libelle_postulants;
    @Column(name = "date_postulants")
    private Date date;

    @ManyToOne
    private Liste_postulants liste_postulants;
}

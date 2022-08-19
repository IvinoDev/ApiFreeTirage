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
@Table(name="Tirage")
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tirage")
    private Long id;

    @Column(name = "libelle_tirage", unique = true)
    private String libelle_tirage;
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_list_postulants")
    private Liste_postulants id_list_postulants;
}

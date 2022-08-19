package ml.freetirage.apitirage.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "postulants_tires")
public class Postulants_Tires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post_tires")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_tirage")
    private Tirage tirage;



}

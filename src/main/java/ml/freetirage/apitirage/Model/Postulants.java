package ml.freetirage.apitirage.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "postulants")
public class Postulants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postulant")
    private Long id;
    @Column(name = "nom_postulant")
    private String nom_postulant;
    @Column(name = "prenom_postulant")
    private String prenom_postulant;
    @Column(name = "numero_postulant")
    private String numero_postulant;
    @Column(name = "mail_postulant")
    private String mail_postulant;


    /*@ManyToOne
    @JoinColumn(name = "id_list_postulants")
    private Liste_postulants id_list_postulants;*/

    /* @OneToMany
    @JoinColumn(name="liste_postulants", referencedColumnName = "id_list_postulants")
    private Liste_postulants liste_postulants; */

   /* public Postulants(){}
    public Postulants(Long id, String nom_postulant, String prenom_postulant, String numero_postulant, String mail_postulant) {
        this.id = id;
        this.nom_postulant = nom_postulant;
        this.prenom_postulant = prenom_postulant;
        this.numero_postulant = numero_postulant;
        this.mail_postulant = mail_postulant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_postulant() {
        return nom_postulant;
    }

    public void setNom_postulant(String nom_postulant) {
        this.nom_postulant = nom_postulant;
    }

    public String getPrenom_postulant() {
        return prenom_postulant;
    }

    public void setPrenom_postulant(String prenom_postulant) {
        this.prenom_postulant = prenom_postulant;
    }

    public String getNumero_postulant() {
        return numero_postulant;
    }

    public void setNumero_postulant(String numero_postulant) {
        this.numero_postulant = numero_postulant;
    }

    public String getMail_postulant() {
        return mail_postulant;
    }

    public void setMail_postulant(String mail_postulant) {
        this.mail_postulant = mail_postulant;
    } */
}

package ma.emsi.springSecurity.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private double salaire;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date daffectation;
    private String departe;
    @ManyToOne
    private Projet projet;
    @OneToMany
    Collection<Reclamation> reclamations;
}

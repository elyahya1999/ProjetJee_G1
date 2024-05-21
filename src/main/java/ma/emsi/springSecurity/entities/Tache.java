package ma.emsi.springSecurity.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String status;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private Projet projet;

}
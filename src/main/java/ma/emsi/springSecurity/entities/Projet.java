package ma.emsi.springSecurity.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Projet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String nom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ddebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dfin;
    private String status;
    private Integer budget;
    @ManyToOne
    private Employe employe;
}

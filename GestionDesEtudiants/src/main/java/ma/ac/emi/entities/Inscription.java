package ma.ac.emi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "etudiant_id")
    private Long etudiantId;

    @Column(name = "cours_id")
    private Long coursId;


    public Inscription(Long etudiantId,Long coursId){
        this.coursId=coursId;
        this.etudiantId=etudiantId;
    }


}

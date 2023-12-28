package ma.ac.emi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
}

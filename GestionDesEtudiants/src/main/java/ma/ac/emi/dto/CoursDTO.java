package ma.ac.emi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CoursDTO {
    private Long id;
    private String libelle;
    private Date dateCreation;
}

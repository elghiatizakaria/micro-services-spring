package ma.ac.emi.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursResponse
{
    private Long id;
    private String libelle;
    private Date dateCreation;

}
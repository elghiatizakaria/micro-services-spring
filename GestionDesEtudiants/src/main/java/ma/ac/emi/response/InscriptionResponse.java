package ma.ac.emi.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionResponse {
    private Long id;
    private Long etudiantId;
    private Long coursId;


}

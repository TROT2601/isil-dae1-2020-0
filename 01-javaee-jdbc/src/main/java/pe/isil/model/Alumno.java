package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alumno {

    private String dni;
    private String apePaterno;
    private String apeMaterno;
    private String nombres;
    private Integer edad;

}

package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {

    private Integer id;
    private String nombre;
    private Integer creditos;
    private String nombreProfesor;

}

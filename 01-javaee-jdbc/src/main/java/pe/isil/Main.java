package pe.isil;

import pe.isil.dao.AlumnoDAO;
import pe.isil.model.Alumno;

public class Main {


    public static void main(String[] args) {

        Alumno a = new Alumno();
        a.setDni("00000000");
        a.setNombres("Jose");
        a.setApePaterno("Ventura");
        a.setApeMaterno("Arteaga");
        a.setEdad(20);

        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.crear(a);


    }

}

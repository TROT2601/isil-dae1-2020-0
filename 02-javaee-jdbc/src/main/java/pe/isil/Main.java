package pe.isil;

import pe.isil.dao.CursoDAO;
import pe.isil.model.Curso;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Curso curso = new Curso();
        curso.setId(1000);
        curso.setNombre("Desarrollo de apli 1");
        curso.setCreditos(3);
        curso.setNombreProfesor("Jose");

        CursoDAO cursoDAO = new CursoDAO();
        cursoDAO.crear(curso);

        listarTodos();

        curso.setNombre("DAE 1");
        curso.setCreditos(4);
        curso.setNombreProfesor("Jose");

        cursoDAO.modificar(curso);

        listarTodos();

        cursoDAO.eliminar(curso);

        listarTodos();

    }

    public static void listarTodos(){
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> listar = cursoDAO.listar();
        for (Curso curso1: listar) {
            System.out.println("=> " + curso1);
        }
    }

}

package pe.isil;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hola mundo! ");

        Alumno a = new Alumno();
        a.setNombres("Jose");
        a.setApellidos("Ventura");
        a.setEdad(20);

        System.out.println("Alumno = " + a);

    }


}

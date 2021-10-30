package ar.com.censo.main;

import ar.com.censo.dominio.Persona;
import ar.com.censo.servicios.Servicio;
import static ar.com.censo.servicios.Servicio.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String arg[]){
        Servicio servicio = new Servicio();

        var persona = new Persona();
        var persona2 = new Persona();
        var persona3 = new Persona();

        System.out.println(persona.toString());
        System.out.println(persona2.toString());
        System.out.println(persona3.toString());

        servicio.agregarPersona(persona);
        servicio.agregarPersona(persona3);
        servicio.agregarPersona(persona2);

        System.out.println(servicio.eliminarPersona(2));
        System.out.println(servicio.eliminarPersona(1));
        System.out.println(servicio.eliminarPersona(7));
        System.out.println(personas);

/*        List<String> nombres = new ArrayList<>();

        Persona persona = new Persona();
        Persona persona1 = new Persona("facundo");

        persona.setApellido("perez");

        nombres.add("Facundo");
        nombres.add("Maxi");
        nombres.add("Fausto");
        System.out.println(nombres);
        System.out.println(nombres.size());
        System.out.println(nombres.get(1));
*/
    }
}

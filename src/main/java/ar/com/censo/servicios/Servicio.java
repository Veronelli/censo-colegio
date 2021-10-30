package ar.com.censo.servicios;

import ar.com.censo.dominio.Persona;

import java.util.ArrayList;
import java.util.List;

public class Servicio {
    static public List<Persona> personas = new ArrayList<Persona>();

    //Metodos agregar
    public String agregarPersona(Persona persona){
        if((persona.getNombre() == null && persona.getApellido() == null &&
                persona.getNacimiento() == null && persona.getEdad() == null)) {
            Servicio.personas.add(persona);
            return "Persona creada";

        }
    return "Persona no creada";

    }

    public String agregarPersona(String nombre,String apellido, int nacimiento, int edad ){
        return this.agregarPersona(new Persona(nombre,apellido,nacimiento,edad));

    }

    //Eliminar metodo
    public String eliminarPersona(Integer id){
        try {
            personas.get(id).isEmpty();
            Persona persona = personas.get(id);
            personas.remove(persona);

            return "Usuario Eliminado";

        } catch (Exception e) {
            return  "No se encontró el usuario";
        }

    }
}

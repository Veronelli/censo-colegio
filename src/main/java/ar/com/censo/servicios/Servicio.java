package ar.com.censo.servicios;

import ar.com.censo.dominio.Persona;

import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private List<Persona> personas = new ArrayList<Persona>();

    //Metodos agregar
    public String agregarPersona(Persona persona){
        if(!(persona.getNombre() == null && persona.getApellido() == null &&
                persona.getNacimiento() == null && persona.getEdad() == null)) {
            personas.add(persona);
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

    //Mostrar Datos
    public Persona getPersona(Integer id){
        for(Persona a : personas){
            if(a.getId() == id) return a;
        }
        return null;
    }

    public List<Persona> getPersonas(){
        return  this.personas;
    }

    //funcion decada: devuelve los dos ultimos digitos de la fecha de nacimiento.

    public Integer decada(Integer anio){
        if(anio<2000){

            anio = anio - 1900;
            return anio;

        }else{

            anio = anio - 2000;
            return anio;

        }
    }

    public String nombreCompleto(String nombre, String apellido){

        return nombre + " " + apellido;

    }

    public boolean esMayor(Integer edad){

        if(edad>=18){

          return true;

        }else{

          return false;

        }

    }

}

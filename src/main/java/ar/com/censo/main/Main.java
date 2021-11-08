package ar.com.censo.main;

import ar.com.censo.dominio.Persona;
import ar.com.censo.servicios.Servicio;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String arg[]){
        Scanner console= new Scanner(System.in);
        Servicio servicio = new Servicio();
        int opcion = -1;
        Integer id;
        try{
          System.out.println("DEV Arg" + arg[0]);
          String aux = "--dev";
          if(arg[0].equals(aux)){
            servicio.agregarPersona("Facu","Vero",20,2002);
            servicio.agregarPersona("Fausto","Gill",10,1934);
            servicio.agregarPersona("Mateo","Sanchez",53,1983);
            servicio.agregarPersona("Leon","Martinez",35,1968);

          }

        }catch(ArrayIndexOutOfBoundsException e){
          System.out.println("PROD");

        }
        while(opcion != 0){
                        System.out.println("=========================================================");
            System.out.println("Seleccione una opcion\n1.Agregar\n2.Eliminar\n3.Buscar\n4.Mostrar lista\n0.Salir\n->");
            opcion = console.nextInt();
                        System.out.println("=========================================================");
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre de la persona:");
                    String nombre = console.next();
                    System.out.println("Ingrese el apellido de la persona:");
                    String apellido = console.next();
                    System.out.println("Ingrese la edad de la persona:");
                    Integer edad = console.nextInt();
                    System.out.println("Ingrese el año de nacimiento de la persona:");
                    Integer nacimiento = console.nextInt();

                    servicio.agregarPersona(nombre,apellido,edad,nacimiento);
                    break;
                case 2:
                    System.out.println("Ingrese el ID de la persona:");
                    id = console.nextInt();
                    System.out.println(servicio.eliminarPersona(id));
                    break;
                case 3:
                    System.out.println("Ingrese el ID de la persona:");
                    id = console.nextInt();
                        System.out.println("=========================================================");
                System.out.println("ID    -     Nombre Completo     -     Edad     -      Decada    -     Mayor");
                    try{
                      Persona persona = servicio.getPersona(id);
                    imprimirPersona(servicio, persona);

                    }catch(NullPointerException e){
                        System.out.println("No se encontró ninguna persona");
                    }

                    break;
               case 4:
                        System.out.println("=========================================================");
               System.out.println("Mayores de edad: " + servicio.cantidadMayores());
                System.out.println("ID    -     Nombre Completo     -     Edad     -      Decada    -     Mayor");
                    servicio.getPersonas().stream().sorted(Comparator.comparing(Persona::getId)).forEach(
                      persona->{
                        Main.imprimirPersona(servicio,persona);                       

                      }
                    );
                    break;

                default:

            }

        }

    
}
public static void imprimirPersona(Servicio servicio,Persona persona){
  Integer _decada = servicio.decada(persona.getNacimiento());
                        String _nombreCompleto = servicio.nombreCompleto(persona.getNombre(),persona.getApellido());
                        String esMayor = (servicio.esMayor(persona.getEdad())) ? "Si" : "No";

                        System.out.println(persona.getId()+"    -       " + _nombreCompleto + "         -     " + persona.getEdad() +"      -      " + _decada + "      -      " + esMayor);

}
}
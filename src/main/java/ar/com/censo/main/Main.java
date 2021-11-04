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
            System.out.println("AA1A");
          if(arg[0].equals(aux)){
            servicio.agregarPersona("Facu","Vero",12,1907);
            servicio.agregarPersona("Fausto","Gill",13,1940);
            servicio.agregarPersona("Mateo","Sanchez",11,2003);
            servicio.agregarPersona("Leon","Martinez",15,1976);

          }

        }catch(ArrayIndexOutOfBoundsException e){
          System.out.println("PROD");

        }
        while(opcion != 0){
            System.out.println("Seleccione una opcion\n1.Agregar\n2.Eliminar\n3.Buscar\n4.Mostrar lista\n0.Salir\n->");
            opcion = console.nextInt();
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

                    servicio.agregarPersona(nombre,apellido,nacimiento,edad);
                    break;
                case 2:
                    System.out.println("Ingrese el ID de la persona:");
                    id = console.nextInt();
                    System.out.println(servicio.eliminarPersona(id));
                    break;
                case 3:
                    System.out.println("Ingrese el ID de la persona:");
                    id = console.nextInt();
                    System.out.println(servicio.getPersona(id));

                    break;
                case 4:
                    servicio.getPersonas().stream().sorted(Comparator.comparing(Persona::getId)).forEach(System.out::println);
                    break;

                default:

            }

        }

    }
}

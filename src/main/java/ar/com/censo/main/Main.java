package ar.com.censo.main;

import ar.com.censo.dominio.Persona;
import javax.swing.*;
import ar.com.censo.servicios.Servicio;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String arg[]){
        Scanner console = new Scanner(System.in);
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
            opcion = MostrarOpciones(opcion); 
            switch (opcion){
                 case 1:
                    
                    
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona (Entre 1 y 10 caracteres):");
                    do{
                      
                      if(nombre.length()>10 || nombre.length()<1){

                        nombre = JOptionPane.showInputDialog("Ingrese un nombre válido (Entre 1 y 10 caracteres)");

                      }
                    }while (nombre.length()>10 || nombre.length()<1);
                    

                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido de la persona:");
                    

                    do{
                      
                      if(apellido.length()>10 || apellido.length()<1){

                        
                        apellido = JOptionPane.showInputDialog("Ingrese un apellido válido (Entre 1 y 10 caracteres)");

                      }
                    }while (apellido.length()>10 || apellido.length()<1);
                    
                    Integer edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la persona (Entre 0 y 120 años):"));


                    do{

                      if(edad<0 || edad > 120){

                        
                        edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una edad válida(Entre 0 y 120 años)"));
                      }
                    }while(edad<0 || edad > 120);

                    
                    
                    Integer nacimiento=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento de la persona: (Entre 1900 y 2020)"));

                    do{

                      if(nacimiento < 1900 || nacimiento > 2020){

                        
                        nacimiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un año válido (Entre 1900 y 2020)"));

                      }

                    }while(nacimiento < 1900 || nacimiento > 2020);
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
               if(servicio.getPersonas().size()>0){
                Object [][] rows = new Object [servicio.getPersonas().size()][5];
                Object[] cols = {"Id","Nombre","Apellido","edad","nacimiento"};
                

                for(int i = 0; i < servicio.getPersonas().size(); i++){
                    int e = i;
                System.out.println(i);
                rows[i][0] = servicio.getPersonas().get(e).getId();
                rows[i][1] = servicio.getPersonas().get(e).getNombre();
                rows[i][2] = servicio.getPersonas().get(e).getApellido();
                rows[i][3] = servicio.getPersonas().get(e).getEdad();
                rows[i][4] = servicio.getPersonas().get(e).getNacimiento();
                }
                JTable table = new JTable(rows,cols);
                JOptionPane.showMessageDialog(null, new JScrollPane(table));
               }else{
                 JOptionPane.showMessageDialog(null, "No hay personas registradas",
      "Hey!", JOptionPane.ERROR_MESSAGE);
               }
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
public static int MostrarOpciones(int opcion){
      opcion = JOptionPane.showOptionDialog( null,"Seleccione una opcion",
        "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
        new Object[] { "Agregar", "Eliminar", "Buscar", "Mostrar Lista"},"opcion 1");

        return opcion += 1;
    }

}
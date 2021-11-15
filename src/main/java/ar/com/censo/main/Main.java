package ar.com.censo.main;

import ar.com.censo.dominio.Persona;
import javax.swing.*;
import ar.com.censo.servicios.Servicio;
import java.util.Scanner;
import java.util.*;
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
                 try{       
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
                    }
                    catch(Exception e){}
                    break;
                case 2:
                try{
                    id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la persona:"));
                    JOptionPane.showMessageDialog(null,servicio.eliminarPersona(id));
                }catch(Exception e){

                }
                    break;
                case 3:
                try{
                    id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la persona:"));
                        
                    try{
                      Persona persona = servicio.getPersona(id);
                      List<Persona> personas = new ArrayList();
                      personas.add(persona);
                      mostrarTabla(personas);

                      }catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null,"No se encontro la persona");
                    }
                  }catch(Exception e){}
                    break;
               case 4:
               if(servicio.getPersonas().size()>0){
                List<Persona> personas = servicio.getPersonas();
                mostrarTabla(personas);
               }else{
                 JOptionPane.showMessageDialog(null, "No hay personas registradas",
      "Hey!", JOptionPane.ERROR_MESSAGE);
               }
                    break;

                default:

            }

        }
    
    
}
public static String imprimirPersona(Servicio servicio,Persona persona){
  Integer _decada = servicio.decada(persona.getNacimiento());
                        String _nombreCompleto = servicio.nombreCompleto(persona.getNombre(),persona.getApellido());
                        String esMayor = (servicio.esMayor(persona.getEdad())) ? "Si" : "No";
                        
                        return "ID: "+ persona.getId()+"|" +"Nombre Completo:  "+ _nombreCompleto + "|"+"Edad:  " + persona.getEdad() +"|"+"Decada:  " + _decada + "|" +"Mayor:  "+ esMayor;

}
public static int MostrarOpciones(int opcion){
      opcion = JOptionPane.showOptionDialog( null,"Seleccione una opcion",
        "Censo",JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
        new Object[] { "Agregar", "Eliminar", "Buscar", "Mostrar Lista"},"opcion 1");

        return opcion += 1;
    }
public static void mostrarTabla(List<Persona> personas){
                  Object [][] rows = new Object [personas.size()][5];
                Object[] cols = {"Id","Nombre","Apellido","edad","nacimiento"};
                

                for(int i = 0; i < personas.size(); i++){
                    int e = i;
                System.out.println(i);
                rows[i][0] =  personas.get(e).getId();
                rows[i][1] =  personas.get(e).getNombre();
                rows[i][2] =  personas.get(e).getApellido();
                rows[i][3] =  personas.get(e).getEdad();
                rows[i][4] =  personas.get(e).getNacimiento();
                }
                JTable table = new JTable(rows,cols);
                JOptionPane.showMessageDialog(null, new JScrollPane(table));

}
}
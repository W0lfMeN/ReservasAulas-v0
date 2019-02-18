/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Tramo;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.iesalandalus.programacion.utilidades.Entrada;

/**
 *
 * @author carlo
 */
public class Consola {
    private static final DateTimeFormatter FORMATO_DIA=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private Consola(){
        
    }
    
    public static void mostrarMenu(){
        System.out.println("-----MENU DE RESERVAS DE AULAS-----");
        System.out.println("");
        System.out.println("1. Insertar aula");
        System.out.println("2. Borrar aula");
        System.out.println("3. Buscar aula");
        System.out.println("4. Listar aulas");
        System.out.println("5. Insertar profesor");
        System.out.println("6. Borrar profesor");
        System.out.println("7. Buscar profesor");
        System.out.println("8. Listar profesores");
        System.out.println("9. Insertar reserva");
        System.out.println("10. Borrar reserva");
        System.out.println("11. Listar reservas");
        System.out.println("12. Listar reservas de un aula");
        System.out.println("13. Listar reservas de un profesor");
        System.out.println("14. Listar reservas en una fecha");
        System.out.println("15. Consultar disponibilidad");
        System.out.println("0. Salir");
    }
    
    public static void mostrarCabecera(String cabecera){
        System.out.println(cabecera);
        
    }
    
    public static void elegirOpcion(){
        int opcion;
        do{
            System.out.println("Introduce una opción");
            opcion=Entrada.entero();
        }while(opcion>0 && opcion<15);
    }
    
    public static Aula leerAula(){
        Aula leida=null;
        do{
            try{
                leida= new Aula(leerNombreAula());
                System.out.println("El aula ha sido leída corretamente");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while (leida==null);
        return leida;
    }
    public static String leerNombreAula(){
        String nombre;
        do{
            System.out.println("Introduce el nombre del aula");
            nombre=Entrada.cadena();
        }while(nombre.equals(""));
        return nombre;
    }
    public static Profesor leerProfesor(){
        Profesor leido=null;
        do{
            try{
                String nombre=leerNombreProfesor();
                System.out.println("Introduce el correo del profesor");
                String correo=Entrada.cadena();
                System.out.println("Introduce el telefono del profesor (opcional)");
                String telefono=Entrada.cadena();
                if(telefono.equals("")){
                    leido= new Profesor(nombre, correo);
                }else{
                    leido= new Profesor(nombre, correo, telefono);
                }
                System.out.println("El profesor ha sido leído corretamente");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while (leido==null);
        return leido;
    }
    public static String leerNombreProfesor(){
        String nombre;
        do{
            System.out.println("Introduce el nombre del profesor");
            nombre=Entrada.cadena();
        }while(nombre.equals(""));
        return nombre;
    }
    public static Tramo leerTramo(){
        int opcion;
        do{
            System.out.println("1 para el Tramo de MAÑANA y 2 para el Tramo de TARDE");
            opcion=Entrada.entero();
        }while(opcion<1 || opcion>2);
        return Tramo.values()[opcion-1];
    }
    
    public static LocalDate leerDia(){
        LocalDate leido=null;
        do{
            System.out.println("Introduce la fecha");
            try{
                leido= LocalDate.parse(Entrada.cadena(), FORMATO_DIA);
            }catch(DateTimeParseException e){
                System.out.println("La fecha introducida no es valida");
            }
        }while(leido==null);
        return leido;
    }
}

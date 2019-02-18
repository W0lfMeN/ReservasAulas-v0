/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import javax.naming.OperationNotSupportedException;

/**
 *
 * @author carlo
 */
public class IUTextual {
    private static final String CORREO_VALIDO="car@car.car";
    private static final String NOMBRE_VALIDO="Carlos";
    private static final String ERROR="ERROR";
    private ModeloReservasAulas modelo;
    
    public IUTextual(){
        this.modelo=new ModeloReservasAulas();
        Opcion.setVista(this);
    }
    public void comenzar(){
        Opcion opcion;
        do{
            Consola.mostrarMenu();
            opcion= Opcion.getOpcionSegunOrdinal(Consola.elegirOpcion());
            opcion.ejecutar();
        }while(opcion != Opcion.SALIR);
    }
    public void salir(){
        System.out.println("Hasta pronto");
    }
    public void insertarAula() throws OperationNotSupportedException{
        Consola.mostrarCabecera("Insertar aula");
        try{
            Aula aula=Consola.leerAula();
            modelo.insertarAula(aula);
            System.out.println("Aula insertada");
        }catch (IllegalArgumentException e){
            System.out.println(ERROR +e.getMessage());
        }
    }
    public void borrarAula()throws OperationNotSupportedException{
        Consola.mostrarCabecera("Borrar aula");
        try{
            Aula aula= Consola.leerAula();
            modelo.borrarAula(aula);
            System.out.println("Aula borrada");
        }catch (IllegalArgumentException e){
            System.out.println(ERROR + e.getMessage());
        }
    }
    public void buscarAula(){
        Consola.mostrarCabecera("Buscar aula");
        Aula aula=null;
        try{
            aula=Consola.leerAula();
            aula=modelo.buscarAula(aula);
            if(aula==null){
                System.out.println("El aula no existe");
            }else{
                System.out.println("El aula buscada es: "+ aula);
            }
        }catch(IllegalArgumentException e){
            System.out.println(ERROR + e.getMessage());
        }
    }
    public void listarAula(){
        Consola.mostrarCabecera("Listar aula");
        String[] aula= modelo.representarAulas();
        if(aula.length> 0){
            for(String aulas : aula){
                System.out.println(aulas);
            }
        }else{
            System.out.println("No hay aulas");
        }
    }
    public void insertarProfesor() throws OperationNotSupportedException{
        Consola.mostrarCabecera("Insertar profesor");
        try{
            Profesor profesor=Consola.leerProfesor();
            modelo.insertarProfesor(profesor);
            System.out.println("profesor insertado");
        }catch (IllegalArgumentException e){
            System.out.println(ERROR +e.getMessage());
        }
    }
    public void borrarProfesor()throws OperationNotSupportedException{
        Consola.mostrarCabecera("Borrar profesor");
        try{
            Profesor profesor= new Profesor (Consola.leerNombreProfesor(), CORREO_VALIDO);
            modelo.borrarProfesor(profesor);
            System.out.println("profesor borrado");
        }catch (IllegalArgumentException e){
            System.out.println(ERROR + e.getMessage());
        }
    }
    public void listarProfesor(){
        Consola.mostrarCabecera("Listar profesor");
        String[] profesor= modelo.representarProfesores();
        if(profesor.length> 0){
            for(String profesores : profesor){
                System.out.println(profesores);
            }
        }else{
            System.out.println("No hay profesores");
        }
    }
    public void realizarReserva() throws OperationNotSupportedException{
        Consola.mostrarCabecera("Realizar reserva");
        Profesor profesor= modelo.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO));
        if(profesor==null){
            System.out.println("El profesor no existe");
        }
        try{
            Reserva reserva= leerReserva(profesor);
            modelo.realizarReserva(reserva);
            System.out.println("Reserva realizada");
        }catch(IllegalArgumentException e){
            System.out.println(ERROR + e.getMessage());
        }
    }
    private Reserva leerReserva(Profesor profesor){
        Aula aula=Consola.leerAula();
        Permanencia permanencia=new Permanencia(Consola.leerDia(), Consola.leerTramo());
        return new Reserva(profesor, aula, permanencia);
    }
    public void anularReserva() throws OperationNotSupportedException{
        Consola.mostrarCabecera("Anular reserva");
        Reserva reserva= leerReserva(new Profesor(NOMBRE_VALIDO, CORREO_VALIDO));
        try{
            modelo.anularReserva(reserva);
            System.out.println("Reserva anulada");
        }catch(IllegalArgumentException e){
            System.out.println(ERROR + e.getMessage());
        }
    }
    public void listarReservas(){
        Consola.mostrarCabecera("Listar reservas");
        String[] reserva= modelo.representarReservas();
        if(reserva.length> 0){
            for(String reservas : reserva){
                System.out.println(reserva);
            }
        }else{
            System.out.println("No hay reservas");
        }
    }
    public void listarReservasAulas(){
        Consola.mostrarCabecera("Listar reservas de aulas");
        Aula aula=Consola.leerAula();
        Reserva[] reservas= modelo.getReservasAula(aula);
        for(int i=0; i<reservas.length;i++){
            if(reservas[i]==null){
                System.out.println("No existen reservas para el aula: "+aula);
            }
            System.out.println(reservas[i]);
        }
    }
    public void listarReservasProfesor(){
        Consola.mostrarCabecera("Listar reservas de profesor");
        Profesor profesor= new Profesor (Consola.leerNombreProfesor(), CORREO_VALIDO);
        Reserva[] reservas= modelo.getReservasProfesor(profesor);
        for(int i=0; i<reservas.length;i++){
            if(reservas[i]==null){
                System.out.println("No existen reservas para el profesor: "+profesor);
            }
            System.out.println(reservas[i]);
        }
    }
    public void listarReservasPermanencia(){
        Consola.mostrarCabecera("Listar reservas de permanencia");
        Permanencia permanencia= new Permanencia(Consola.leerDia(), Consola.leerTramo());
        Reserva[] reservas= modelo.getReservasPermanencia(permanencia);
        for(int i=0; i<reservas.length;i++){
            if(reservas[i]==null){
                System.out.println("No existen reservas para la permanencia: "+permanencia);
            }
            System.out.println(reservas[i]);
        }
    }
    public void consultarDisponibilidad(){
        Consola.mostrarCabecera("Consultar la disponibilidad");
        Aula aula=Consola.leerAula();
        Permanencia permanencia= new Permanencia(Consola.leerDia(), Consola.leerTramo());
        boolean disponibilidad=modelo.consultarDisponibilidad(permanencia, aula);
        if(disponibilidad==true){
            System.out.println("La reserva está disponible");
        }else{
            System.out.println("La reserva no está disponible");
        }
    }

    void buscarProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


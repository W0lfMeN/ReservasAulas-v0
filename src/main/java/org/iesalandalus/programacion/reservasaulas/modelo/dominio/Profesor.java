/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author carlo
 */
public class Profesor {
    private static final String ER_TELEFONO="^[69][0-9]{8}$";
    private static final String ER_CORREO="^[a-z0-9]+(\\.[a-z0-9]+)*@[a-z]+(\\.[a-z]+)*(\\.[a-z]{1,4})$";
    private String nombre;
    private String correo;
    private String telefono;
    
    public Profesor (String nombre, String correo){
        setCorreo(correo);
        setNombre(nombre);
    }
    public Profesor (String nombre, String correo, String telefono){
        setCorreo(correo);
        setNombre(nombre);
        setTelefono(telefono);
    }
    public Profesor(Profesor p){
        if(p==null){
            throw new IllegalArgumentException("No se puede copiar un profesor nulo.");
        }
        setCorreo(p.correo);
        setNombre(p.nombre);
        setTelefono(p.telefono);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        if(nombre==null){
            throw new IllegalArgumentException("El nombre del profesor no puede ser nulo.");
        }
        if (nombre.equals("")){
            throw new IllegalArgumentException("El nombre del profesor no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(correo==null){
          throw new IllegalArgumentException("El correo del profesor no puede ser nulo.");
        
        }else{
           if(Pattern.matches(ER_CORREO, correo)){
               this.correo=correo;
           }else{
               throw new IllegalArgumentException("El correo del profesor no es válido.");
            }
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(telefono==null){
          this.telefono=null;
          
        }else{
           if(Pattern.matches(ER_TELEFONO, telefono)){
               this.telefono=telefono;
           }else{
               throw new IllegalArgumentException("El teléfono del profesor no es válido.");
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        if(telefono==null){
         return "[nombre=" +nombre+ ", correo=" +correo+ "]";
        }else{
         return "[nombre=" +nombre+ ", correo=" +correo+ ", telefono=" +telefono+ "]";   
        }
    }
    
    
    
}

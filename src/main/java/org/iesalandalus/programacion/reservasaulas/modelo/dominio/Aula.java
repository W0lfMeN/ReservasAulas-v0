/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;

/**
 *
 * @author carlo
 */
public class Aula {
    private String nombre;
    
    public Aula(String nombre){ //constructor
        setNombre(nombre);
    }
    
    public Aula(Aula a){ //constructor por defecto
        if(a==null){
            throw new IllegalArgumentException("No se puede copiar un aula nula.");
        }
        setNombre(a.getNombre());
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        if(nombre==null){
            throw new IllegalArgumentException("El nombre del aula no puede ser nulo.");
        }
        if (nombre.equals("")){
            throw new IllegalArgumentException("El nombre del aula no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nombre);
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
        final Aula other = (Aula) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[nombre=" +nombre+ "]";
    }
    
    
}

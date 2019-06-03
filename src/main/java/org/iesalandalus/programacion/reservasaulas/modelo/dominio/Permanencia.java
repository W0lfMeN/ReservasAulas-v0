/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
/**
 *
 * @author carlo
 */
public class Permanencia {
    private Tramo tramo;
    private LocalDate dia;
    private static final DateTimeFormatter FORMATO_DIA=DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     *
     * @param dia
     * @param tramo
     */
    public Permanencia(LocalDate dia, Tramo tramo){ //constructor 
        setDia(dia);
        setTramo(tramo);
    }
    
    /**
     *
     * @param p
     */
    public Permanencia (Permanencia p){ //constructor copia
        if(p==null){
            throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
        }
        setDia(p.dia);
        setTramo(p.tramo);
    }
    
    public Tramo getTramo() {
        return tramo;
    }

    private void setTramo(Tramo tramo) {
        if(tramo==null){
            throw new IllegalArgumentException("El tramo de una permanencia no puede ser nulo.");
        }
        this.tramo = tramo;
    }

    public LocalDate getDia() {
        return LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
    }

    private void setDia(LocalDate dia) {
        if(dia==null){
            throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
        }
        this.dia = LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.tramo);
        hash = 31 * hash + Objects.hashCode(this.dia);
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
        final Permanencia other = (Permanencia) obj;
        if (this.tramo != other.tramo) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "[dia=" +getDia().format(FORMATO_DIA)+", tramo=" +getTramo()+ "]";
    }
        
}

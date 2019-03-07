/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author jorge diaz
 */
public class QuejaYReclamos {
    int id_queja;
    Date fecha;
    String descripcion;

    public int getId_queja() {
        return id_queja;
    }

    public void setId_queja(int id_queja) {
        this.id_queja = id_queja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
